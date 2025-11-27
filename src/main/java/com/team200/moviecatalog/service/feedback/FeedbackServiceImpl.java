package com.team200.moviecatalog.service.feedback;

import com.team200.moviecatalog.dto.feedback.FeedbackRequestDto;
import com.team200.moviecatalog.dto.feedback.FeedbackResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.FeedbackMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Rating;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.service.rating.MovieRatingUpdater;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private static final String USER_NOT_FOUND = "User not found: ";
    private static final String MOVIE_NOT_FOUND = "Movie not found: ";
    private static final String DUPLICATE_REVIEW = "Review already exists for this movie";
    private static final String DUPLICATE_RATING = "Rating already exists for this movie";

    private final ReviewRepository reviewRepository;
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final FeedbackMapper feedbackMapper;
    private final MovieRatingUpdater movieRatingUpdater;

    @Override
    @Transactional(readOnly = true)
    public List<FeedbackResponseDto> getFeedbackByMovie(Long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);

        return reviews.stream()
                .map(review -> {
                    Integer rating = ratingRepository.findValueByMovieAndUser(
                            movieId,
                            review.getUser().getId()
                    );
                    return feedbackMapper.toDto(review, rating);
                })
                .toList();
    }

    @Override
    @Transactional
    public FeedbackResponseDto createFeedback(
            Long movieId,
            FeedbackRequestDto dto,
            UserDetails userDetails) {
        User author = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() ->
                        new EntityNotFoundException(MOVIE_NOT_FOUND + movieId));

        Review existingReview = reviewRepository
                .findByMovieIdAndUserId(movieId, author.getId())
                .orElse(null);

        Integer existingRating = ratingRepository
                .findValueByMovieAndUser(movieId, author.getId());

        if (dto.reviewText() != null) {
            if (existingReview != null && existingReview.getComment() != null) {
                throw new ConflictException(DUPLICATE_REVIEW);
            }
            Review review = existingReview != null ? existingReview : new Review();
            review.setMovie(movie);
            review.setUser(author);
            review.setComment(dto.reviewText());
            review.setCreatedAt(LocalDateTime.now());
            reviewRepository.save(review);
        }

        if (dto.ratingValue() != null) {
            if (existingRating != null) {
                throw new ConflictException(DUPLICATE_RATING);
            }
            Rating rating = new Rating();
            rating.setMovie(movie);
            rating.setUser(author);
            rating.setValue(dto.ratingValue());
            ratingRepository.save(rating);

            movieRatingUpdater.recalculateAndSaveAverage(movie);
        }

        Integer finalRating = ratingRepository.findValueByMovieAndUser(
                movieId, author.getId());
        Review finalReview = reviewRepository.findByMovieIdAndUserId(
                movieId, author.getId()).orElse(null);

        return feedbackMapper.toDto(finalReview, finalRating);
    }
}
