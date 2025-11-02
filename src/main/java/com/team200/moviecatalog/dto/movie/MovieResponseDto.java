package com.team200.moviecatalog.dto.movie;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieResponseDto(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        Integer year,
        Integer duration,
        BigDecimal averageRating,
        String posterUrl,
        String trailerUrl,
        String ageRating,
        String category
) {}
