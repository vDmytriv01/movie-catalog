package com.team200.moviecatalog.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginRequestDto(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
