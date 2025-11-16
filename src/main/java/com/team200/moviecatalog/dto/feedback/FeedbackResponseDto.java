package com.team200.moviecatalog.dto.feedback;

import java.time.LocalDateTime;

public record FeedbackResponseDto(
        Long id,
        String nickname,
        Integer rating,
        String comment,
        LocalDateTime createdAt,
        String type
) {
}
