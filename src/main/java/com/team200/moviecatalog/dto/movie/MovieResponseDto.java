package com.team200.moviecatalog.dto.movie;

import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

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
        Set<String> genres,
        Set<String> countries,
        AgeRating ageRating,
        Category category
) {
}
