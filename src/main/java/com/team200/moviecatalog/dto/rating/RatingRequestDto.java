package com.team200.moviecatalog.dto.rating;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RatingRequestDto(
        @NotNull
        @Min(1)
        @Max(10)
        Integer value,
        @NotNull
        Long movieId,
        @NotNull
        Long userId
) {
}
