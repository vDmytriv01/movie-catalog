package com.team200.moviecatalog.dto.movie;

import jakarta.validation.constraints.NotBlank;

public record MovieWatchLinkCreateRequest(
        @NotBlank String url,
        String platformName
) {
}
