package com.team200.moviecatalog.service.review;

import com.team200.moviecatalog.dto.review.ReviewRequestDto;
import com.team200.moviecatalog.dto.review.ReviewResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.ReviewMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private static final String USER_NOT_FOUND = "User not found: ";
    private static final String MOVIE_NOT_FOUND = "Movie not found: ";
    private static final String DUPLICATE_REVIEW = "Review already exists for this movie";

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Transactional
    public ReviewResponseDto addReview(ReviewRequestDto dto, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(() ->
                        new EntityNotFoundException(MOVIE_NOT_FOUND + dto.movieId()));

        if (reviewRepository.existsByMovieIdAndUserId(movie.getId(), user.getId())) {
            throw new ConflictException(DUPLICATE_REVIEW);
        }

        Review review = reviewMapper.toEntity(dto);
        review.setUser(user);
        review.setMovie(movie);
        review.setCreatedAt(LocalDateTime.now());

        return reviewMapper.toDto(reviewRepository.save(review));
    }

    public List<ReviewResponseDto> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId)
                .stream()
                .map(reviewMapper::toDto)
                .toList();
    }
}
