package com.team200.moviecatalog.dto.review;

import java.time.LocalDateTime;

public record ReviewResponseDto(
        Long id,
        String comment,
        Long movieId,
        Long userId,
        LocalDateTime createdAt) {
}
