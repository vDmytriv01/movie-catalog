package com.team200.moviecatalog.dto.review;

public record ReviewResponseDto(
        Long id,
        String comment,
        Long movieId,
        Long userId) {
}
