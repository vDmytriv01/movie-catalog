package com.team200.moviecatalog.service.comment;

import com.team200.moviecatalog.dto.comment.ReviewCommentRequestDto;
import com.team200.moviecatalog.dto.comment.ReviewCommentResponseDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

public interface ReviewCommentService {

    ReviewCommentResponseDto addComment(Long reviewId,
                                        ReviewCommentRequestDto dto,
                                        UserDetails userDetails);

    List<ReviewCommentResponseDto> getCommentsByReview(Long reviewId);
}
