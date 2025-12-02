package com.team200.moviecatalog.dto.movie;

import java.util.List;

public record MovieFiltersResponseDto(
        List<String> categories,
        List<String> genres,
        List<String> ageRating,
        List<Integer> years,
        List<Double> ratingValues
) {
}
