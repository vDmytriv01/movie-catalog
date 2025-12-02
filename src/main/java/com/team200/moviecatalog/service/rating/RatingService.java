package com.team200.moviecatalog.service.rating;

import com.team200.moviecatalog.dto.rating.RatingRequestDto;
import com.team200.moviecatalog.dto.rating.RatingResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
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
    private static final String RATING_NOT_FOUND = "Rating not found for movie: ";
    private static final String DUPLICATE_RATING = "Rating already exists for this movie";

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final RatingMapper ratingMapper;
    private final MovieRatingUpdater movieRatingUpdater;

    @Transactional
    public RatingResponseDto createRating(RatingRequestDto dto, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(() ->
                        new EntityNotFoundException(MOVIE_NOT_FOUND + dto.movieId()));

        if (ratingRepository.findByUserIdAndMovieId(user.getId(), movie.getId()).isPresent()) {
            throw new ConflictException(DUPLICATE_RATING);
        }

        Rating rating = ratingMapper.toEntity(dto);
        rating.setUser(user);
        rating.setMovie(movie);

        Rating saved = ratingRepository.save(rating);

        movieRatingUpdater.recalculateAndSaveAverage(movie);

        return ratingMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public RatingResponseDto getRating(Long movieId, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Rating rating = ratingRepository.findByUserIdAndMovieId(user.getId(), movieId)
                .orElseThrow(() -> new EntityNotFoundException(RATING_NOT_FOUND + movieId));

        return ratingMapper.toDto(rating);
    }
}
