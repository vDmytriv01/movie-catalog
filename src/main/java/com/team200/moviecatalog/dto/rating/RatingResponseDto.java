package com.team200.moviecatalog.dto.rating;

public record RatingResponseDto(
        Long id,
        Integer value,
        Long movieId,
        Long userId
) {
}
