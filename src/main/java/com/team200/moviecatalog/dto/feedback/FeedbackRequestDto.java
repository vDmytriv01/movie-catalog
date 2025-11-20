package com.team200.moviecatalog.dto.feedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record FeedbackRequestDto(
        @Min(1)
        @Max(10)
        Integer ratingValue,

        @Size(max = 2000)
        String reviewText) {
}
