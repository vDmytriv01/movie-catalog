package com.team200.moviecatalog.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReviewRequestDto(
        @NotBlank
        String comment,
        @NotNull
        Long movieId
) {
}
