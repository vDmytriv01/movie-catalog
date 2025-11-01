package com.team200.moviecatalog.dto.genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GenreRequestDto(
        @NotBlank
        @Size(max = 255)
        String name
) {
}
