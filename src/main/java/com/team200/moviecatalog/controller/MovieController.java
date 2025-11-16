package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.service.movie.MovieService;
import com.team200.moviecatalog.service.movieactor.MovieActorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieActorService movieActorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto createMovie(@RequestBody MovieRequestDto dto) {
        return movieService.createMovie(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponseDto updateMovie(@PathVariable Long id,
                                        @RequestBody MovieRequestDto dto) {
        return movieService.updateMovie(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDeleteMovie(@PathVariable Long id) {
        movieService.softDeleteMovie(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieShortResponseDto> getAllMovies(Pageable pageable) {
        return movieService.getAllShort(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieFullResponseDto getMovieById(@PathVariable Long id) {
        return movieService.getFullById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieShortResponseDto> searchMovies(
            MovieSearchParametersDto params,
            Pageable pageable) {
        return movieService.search(params, pageable);
    }

    @GetMapping("/filters")
    @ResponseStatus(HttpStatus.OK)
    public MovieFiltersResponseDto getFilters() {
        return movieService.getFilters();
    }

    @GetMapping("/top/season/current")
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieShortResponseDto> getTopByCurrentSeason(Pageable pageable) {
        return movieService.getTopByCurrentSeason(pageable);
    }

    @GetMapping("/{id}/similar")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieShortResponseDto> getSimilarMovies(@PathVariable Long id) {
        return movieService.getSimilarMovies(id);
    }

    @GetMapping("/{id}/actors")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieActorDto> getActorsByMovie(@PathVariable Long id) {
        return movieActorService.getCastByMovie(id);
    }
}
