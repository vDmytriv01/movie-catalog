package com.team200.moviecatalog.dto.user;

import jakarta.validation.constraints.Size;

public record UpdateUserRequestDto(
        @Size(min = 3, max = 30)
        String nickname,

        @Size(max = 255)
        String profileUrl
) {}
