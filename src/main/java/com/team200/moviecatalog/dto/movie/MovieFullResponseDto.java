package com.team200.moviecatalog.dto.movie;

import com.team200.moviecatalog.dto.rating.RatingResponseDto;
import com.team200.moviecatalog.dto.review.ReviewResponseDto;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record MovieFullResponseDto(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        Integer year,
        Integer duration,
        BigDecimal averageRating,
        String posterUrl,
        String trailerUrl,
        Set<String> directors,
        Set<String> genres,
        Set<String> actors,
        Set<String> countries,
        AgeRating ageRating,
        Category category,
        List<ReviewResponseDto> reviews,
        List<RatingResponseDto> ratings
) {}
