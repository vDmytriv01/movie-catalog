package com.team200.moviecatalog.dto.movie;

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
        Set<String> countries,
        BigDecimal averageRating,
        String posterUrl,
        String trailerUrl,
        Set<String> directors,
        Set<String> genres,
        Set<String> actors,
        String ageRating,
        String category) {

}
