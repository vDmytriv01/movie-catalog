package com.team200.moviecatalog.dto.review;

import com.team200.moviecatalog.dto.comment.ReviewCommentResponseDto;
import java.time.LocalDateTime;
import java.util.List;

public record ReviewResponseDto(
        Long id,
        String comment,
        Long movieId,
        String userNickname,
        LocalDateTime createdAt,
        List<ReviewCommentResponseDto> comments
) {
}
