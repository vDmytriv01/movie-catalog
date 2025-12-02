package com.team200.moviecatalog.dto.feedback;

import java.time.LocalDateTime;

public record FeedbackResponseDto(
        Long reviewId,
        Long movieId,
        Integer rating,
        String comment,
        String nickname,
        LocalDateTime createdAt
) {
}
