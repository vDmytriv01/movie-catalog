package com.team200.moviecatalog.dto.movie;

import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record MovieRequestDto(

        @NotBlank
        @Size(max = 255)
        String title,

        @Size(max = 2000)
        String description,

        LocalDate releaseDate,

        @Positive
        Integer year,

        @Positive
        Integer duration,

        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "10.0", inclusive = true)
        BigDecimal averageRating,

        @Size(max = 500)
        String posterUrl,

        @Size(max = 500)
        String trailerUrl,

        boolean isFree,

        Set<Long> directorIds,

        Set<Long> genreIds,

        Set<Long> countryIds,

        AgeRating ageRating,

        Category category
) {
}
