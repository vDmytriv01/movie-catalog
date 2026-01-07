package com.team200.moviecatalog.dto.user;

public record ChangePasswordRequestDto(
        String oldPassword,
        String newPassword,
        String repeatNewPassword
) {
}
