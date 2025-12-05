package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkCreateRequest;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkDto;
import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.service.movie.MovieService;
import com.team200.moviecatalog.service.movieactor.MovieActorService;
import com.team200.moviecatalog.service.moviewatchlink.MovieWatchLinkService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class MovieController {

    private final MovieService movieService;
    private final MovieActorService movieActorService;
    private final MovieWatchLinkService movieWatchLinkService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto createMovie(@Valid @RequestBody MovieRequestDto dto) {
        return movieService.createMovie(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponseDto updateMovie(@PathVariable @Positive Long id,
                                        @Valid @RequestBody MovieRequestDto dto) {
        return movieService.updateMovie(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDeleteMovie(@PathVariable @Positive Long id) {
        movieService.softDeleteMovie(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieShortResponseDto> getAllMovies(Pageable pageable) {
        return movieService.getAllShort(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieFullResponseDto getMovieById(@PathVariable @Positive Long id) {
        return movieService.getFullById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/watch-links")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieWatchLinkDto addWatchLink(@PathVariable @Positive Long id,
                                          @Valid @RequestBody MovieWatchLinkCreateRequest request) {
        return movieWatchLinkService.addWatchLink(id, request);
    }

    @GetMapping("/{id}/watch-links")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieWatchLinkDto> getWatchLinks(@PathVariable @Positive Long id) {
        return movieWatchLinkService.getWatchLinksForMovie(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieShortResponseDto> searchMovies(
            @Valid MovieSearchParametersDto params,
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
    public List<MovieShortResponseDto> getSimilarMovies(@PathVariable @Positive Long id) {
        return movieService.getSimilarMovies(id);
    }

    @GetMapping("/{id}/actors")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieActorDto> getActorsByMovie(@PathVariable @Positive Long id) {
        return movieActorService.getCastByMovie(id);
    }
}
