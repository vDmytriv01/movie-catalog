package com.team200.moviecatalog.dto.feedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FeedbackRequestDto(
        @NotNull
        @Min(1)
        @Max(10)
        Integer ratingValue,

        @NotBlank
        @Size(max = 2000)
        String reviewText) {
}
