package com.team200.moviecatalog.service.rating;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieRatingUpdater {

    private static final int SCALE = 2;

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    public BigDecimal recalculateAndSaveAverage(Movie movie) {
        List<Integer> ratings = ratingRepository.findAllValuesByMovieId(movie.getId());
        BigDecimal average = calculateAverage(ratings);
        movie.setAverageRating(average);
        movieRepository.save(movie);
        return average;
    }

    private BigDecimal calculateAverage(List<Integer> ratings) {
        if (ratings == null || ratings.isEmpty()) {
            return BigDecimal.ZERO.setScale(SCALE, RoundingMode.HALF_UP);
        }

        double average = ratings.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        return BigDecimal.valueOf(average).setScale(SCALE, RoundingMode.HALF_UP);
    }
}
