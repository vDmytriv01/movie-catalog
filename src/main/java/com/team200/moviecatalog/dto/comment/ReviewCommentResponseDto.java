package com.team200.moviecatalog.dto.comment;

import java.time.LocalDateTime;

public record ReviewCommentResponseDto(
        Long id,
        String content,
        String userNickname,
        Long parentCommentId,
        LocalDateTime createdAt
) {
}
