package com.team200.moviecatalog.service.comment;

import com.team200.moviecatalog.dto.comment.ReviewCommentRequestDto;
import com.team200.moviecatalog.dto.comment.ReviewCommentResponseDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.ReviewCommentMapper;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.ReviewComment;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.comment.ReviewCommentRepository;
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
public class ReviewCommentServiceImpl implements ReviewCommentService {

    private static final String USER_NOT_FOUND = "User not found: ";
    private static final String REVIEW_NOT_FOUND = "Review not found: ";

    private final ReviewCommentRepository commentRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewCommentMapper commentMapper;

    @Override
    @Transactional
    public ReviewCommentResponseDto addComment(Long reviewId,
                                               ReviewCommentRequestDto dto,
                                               UserDetails userDetails) {

        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND + userDetails.getUsername()));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new EntityNotFoundException(REVIEW_NOT_FOUND + reviewId));

        ReviewComment comment = commentMapper.toEntity(dto);
        comment.setUser(user);
        comment.setReview(review);
        comment.setCreatedAt(LocalDateTime.now());

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReviewCommentResponseDto> getCommentsByReview(Long reviewId) {
        return commentRepository.findByReviewId(reviewId)
                .stream()
                .map(commentMapper::toDto)
                .toList();
    }
}
