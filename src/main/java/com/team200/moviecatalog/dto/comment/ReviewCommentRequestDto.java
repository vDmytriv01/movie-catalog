package com.team200.moviecatalog.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ReviewCommentRequestDto(
        @NotBlank
        @Size(max = 500)
        String content,

        @PositiveOrZero
        Long parentCommentId
) {
}
