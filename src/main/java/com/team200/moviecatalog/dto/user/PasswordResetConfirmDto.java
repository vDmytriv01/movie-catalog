package com.team200.moviecatalog.dto.user;

import com.team200.moviecatalog.constants.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PasswordResetConfirmDto(
        @NotBlank
        String token,
        @NotBlank
        @Size(min = 8, max = 64)
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,64}$",
                message = ValidationMessages.PASSWORD_PATTERN
        )
        String newPassword
) {
}
