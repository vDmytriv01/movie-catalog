package com.team200.moviecatalog.service.review;

import com.team200.moviecatalog.dto.review.ReviewRequestDto;
import com.team200.moviecatalog.dto.review.ReviewResponseDto;
import com.team200.moviecatalog.mapper.ReviewMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Transactional
    public ReviewResponseDto addReview(ReviewRequestDto dto, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Review review = reviewMapper.toEntity(dto);
        review.setUser(user);
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
