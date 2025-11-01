package com.team200.moviecatalog.dto.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CountryRequestDto(
        @NotBlank
        @Size(max = 255)
        String name) {
}
