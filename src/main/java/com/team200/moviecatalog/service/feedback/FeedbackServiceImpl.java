package com.team200.moviecatalog.service.feedback;

import com.team200.moviecatalog.dto.feedback.FeedbackRequestDto;
import com.team200.moviecatalog.dto.feedback.FeedbackResponseDto;
import com.team200.moviecatalog.mapper.FeedbackMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Rating;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final ReviewRepository reviewRepository;
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final FeedbackMapper feedbackMapper;

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
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Review existingReview = reviewRepository.findByMovieIdAndUserId(
                movieId, author.getId()).orElse(null);
        Integer existingRating = ratingRepository.findValueByMovieAndUser(movieId, author.getId());

        if (dto.reviewText() != null) {
            if (existingReview != null && existingReview.getComment() != null) {
                throw new IllegalStateException("You have already added a review for this movie");
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
                throw new IllegalStateException("You have already rated this movie");
            }
            Rating rating = new Rating();
            rating.setMovie(movie);
            rating.setUser(author);
            rating.setValue(dto.ratingValue());
            ratingRepository.save(rating);

            updateMovieAverageRating(movie);
        }

        Integer finalRating = ratingRepository.findValueByMovieAndUser(
                movieId, author.getId());
        Review finalReview = reviewRepository.findByMovieIdAndUserId(
                movieId, author.getId()).orElse(null);

        return feedbackMapper.toDto(finalReview, finalRating);
    }

    private void updateMovieAverageRating(Movie movie) {
        List<Integer> ratings = ratingRepository.findAllValuesByMovieId(movie.getId());
        if (ratings.isEmpty()) {
            movie.setAverageRating(BigDecimal.ZERO);
        } else {
            double avg = ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
            movie.setAverageRating(BigDecimal.valueOf(avg).setScale(1, RoundingMode.HALF_UP));
        }
        movieRepository.save(movie);
    }
}
