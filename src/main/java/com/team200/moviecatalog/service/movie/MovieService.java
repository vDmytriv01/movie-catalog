package com.team200.moviecatalog.service.movie;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    MovieFullResponseDto createMovie(MovieRequestDto dto);

    MovieFullResponseDto updateMovie(Long id, MovieRequestDto dto);

    void softDeleteMovie(Long id);

    Page<MovieShortResponseDto> getAllShort(Pageable pageable);

    MovieFullResponseDto getFullById(Long id);

    Page<MovieShortResponseDto> search(MovieSearchParametersDto params, Pageable pageable);

    MovieFiltersResponseDto getFilters();

    Page<MovieShortResponseDto> getTopByCurrentSeason(Pageable pageable);
}
