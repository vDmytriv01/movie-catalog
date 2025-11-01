package com.team200.moviecatalog.dto.actor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ActorRequestDto(
        @NotBlank
        @Size(max = 255)
        String fullName) {
}
