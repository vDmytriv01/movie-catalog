package com.team200.moviecatalog.service.rating;

import com.team200.moviecatalog.repository.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MovieRatingUpdater {

    private final MovieRepository movieRepository;

    @Transactional
    public void recalculateAndSaveAggregates(Long movieId) {
        movieRepository.updateRatingAggregates(movieId);
    }
}
