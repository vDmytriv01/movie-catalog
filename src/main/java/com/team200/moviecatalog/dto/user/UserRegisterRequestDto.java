package com.team200.moviecatalog.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRegisterRequestDto(
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Nickname is required")
        String nickname,

        @NotBlank(message = "Password is required")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,64}$",
                message = "Password must contain at least one letter, "
                        + "one number, no spaces, and be 8–64 chars long"
        )
        String password,

        @NotBlank(message = "Repeat password is required")
        String repeatPassword
) {
}
