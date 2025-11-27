package com.team200.moviecatalog.dto.user;

import com.team200.moviecatalog.constants.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRegisterRequestDto(
        @NotBlank(message = ValidationMessages.EMAIL_REQUIRED)
        @Email(message = ValidationMessages.EMAIL_INVALID)
        String email,

        @NotBlank(message = ValidationMessages.NICKNAME_REQUIRED)
        String nickname,

        @NotBlank(message = ValidationMessages.PASSWORD_REQUIRED)
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,64}$",
                message = ValidationMessages.PASSWORD_PATTERN
        )
        String password,

        @NotBlank(message = ValidationMessages.REPEAT_PASSWORD_REQUIRED)
        String repeatPassword
) {
}
