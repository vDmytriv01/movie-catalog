package com.team200.moviecatalog.dto.user;

public record GoogleOAuthUserDto(
        String email,
        String nickname,
        String pictureUrl
) {
}
