package com.team200.moviecatalog.dto.user;

public record UserResponseDto(
        Long id,
        String email,
        String nickname,
        String profileImageUrl
) {
}
