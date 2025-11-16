package com.team200.moviecatalog.dto.feedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record FeedbackRequestDto(
        @Min(1)
        @Max(10)
        Integer ratingValue,
        String reviewText
) {
}
