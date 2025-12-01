package com.team200.moviecatalog.dto.user;

import jakarta.validation.constraints.NotBlank;

public record GoogleOAuthRequestDto(
        @NotBlank
        String idToken
) {
}
