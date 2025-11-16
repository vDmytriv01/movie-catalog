package com.team200.moviecatalog.dto.movie;

import java.util.List;

public record MovieFiltersResponseDto(
        List<String> categories,
        List<String> genres,
        List<String> ageRatings,
        List<Integer> years,
        List<Double> ratingValues
) {
}
