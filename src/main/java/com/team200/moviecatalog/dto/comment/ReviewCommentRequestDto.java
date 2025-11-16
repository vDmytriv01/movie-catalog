package com.team200.moviecatalog.dto.comment;

import jakarta.validation.constraints.NotBlank;

public record ReviewCommentRequestDto(
        @NotBlank
        String content,
        Long parentCommentId
) {
}
