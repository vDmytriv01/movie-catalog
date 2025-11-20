package com.team200.moviecatalog.dto.movie;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record MovieSearchParametersDto(

        @Size(max = 255)
        String title,

        @Min(1900)
        @Max(2100)
        Integer year,

        String genre,
        String ageRating,
        String category,

        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double minRating) {

}
