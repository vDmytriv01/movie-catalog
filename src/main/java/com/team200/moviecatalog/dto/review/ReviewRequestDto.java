package com.team200.moviecatalog.dto.review;

import jakarta.validation.constraints.Size;

public record ReviewRequestDto(
        @Size(max = 2000)
        String comment,
        Long movieId,
        Long userId) {

}
