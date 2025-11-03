package com.team200.moviecatalog.service;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import java.util.List;

public interface MovieService {

    List<MovieShortResponseDto> getAllShort();

    MovieFullResponseDto getFullById(Long id);

    List<MovieShortResponseDto> search(MovieSearchParametersDto params);

    MovieFiltersResponseDto getFilters();
}

