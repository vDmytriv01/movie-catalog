package com.team200.moviecatalog.dto.movie;

import java.math.BigDecimal;

public record MovieShortResponseDto(
        Long id,
        String title,
        String genres,
        Integer year,
        BigDecimal averageRating,
        String posterUrl
) {}
