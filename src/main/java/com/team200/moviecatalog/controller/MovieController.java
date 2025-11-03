package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieShortResponseDto> getAllMovies() {
        return movieService.getAllShort();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieFullResponseDto getMovieById(@PathVariable Long id) {
        return movieService.getFullById(id);
    }

    @GetMapping("/search")
    public List<MovieShortResponseDto> searchMovies(MovieSearchParametersDto params) {
        return movieService.search(params);
    }

    @GetMapping("/filters")
    public MovieFiltersResponseDto getFilters() {
        return movieService.getFilters();
    }
}
