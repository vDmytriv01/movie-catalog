package com.team200.moviecatalog.dto.director;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DirectorRequestDto(
        @NotBlank
        @Size(max = 255)
        String fullName) {
}
