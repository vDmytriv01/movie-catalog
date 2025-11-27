package com.team200.moviecatalog.service.rating;

import com.team200.moviecatalog.dto.rating.RatingRequestDto;
import com.team200.moviecatalog.dto.rating.RatingResponseDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.RatingMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Rating;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RatingService {

    private static final String USER_NOT_FOUND = "User not found: ";
    private static final String MOVIE_NOT_FOUND = "Movie not found: ";

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final RatingMapper ratingMapper;
    private final MovieRatingUpdater movieRatingUpdater;

    @Transactional
    public RatingResponseDto addOrUpdateRating(RatingRequestDto dto, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(() ->
                        new EntityNotFoundException(MOVIE_NOT_FOUND + dto.movieId()));

        Rating rating = ratingRepository.findByUserIdAndMovieId(user.getId(), movie.getId())
                .map(existing -> {
                    existing.setValue(dto.value());
                    return existing;
                })
                .orElseGet(() -> {
                    Rating newRating = ratingMapper.toEntity(dto);
                    newRating.setUser(user);
                    newRating.setMovie(movie);
                    return newRating;
                });

        Rating saved = ratingRepository.save(rating);

        movieRatingUpdater.recalculateAndSaveAverage(movie);

        return ratingMapper.toDto(saved);
    }
}
