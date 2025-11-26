package com.team200.moviecatalog.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordResetConfirmDto(
        @NotBlank
        String token,
        @NotBlank
        @Size(min = 8, max = 64)
        String newPassword
) {
}
