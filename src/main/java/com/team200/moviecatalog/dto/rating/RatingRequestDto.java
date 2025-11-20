package com.team200.moviecatalog.dto.rating;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RatingRequestDto(
        @NotNull
        @Min(1)
        @Max(10)
        Integer value,

        @NotNull
        @Positive
        Long movieId) {
}
