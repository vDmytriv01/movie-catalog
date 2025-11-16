package com.team200.moviecatalog.dto.movie;

public record MovieSearchParametersDto(
        String title,
        Integer year,
        String genre,
        String ageRating,
        String category,
        Double minRating
) {
}
