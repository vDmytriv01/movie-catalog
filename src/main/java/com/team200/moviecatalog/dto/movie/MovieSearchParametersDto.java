package com.team200.moviecatalog.dto.movie;

public record MovieSearchParametersDto(
        String title,
        Integer year,
        String[] genres,
        String[] countries,
        String[] ageRatings,
        String[] categories,
        Double minRating
) {}
