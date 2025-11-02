package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.model.Movie;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface MovieMapper {
    Movie toEntity(MovieRequestDto dto);

    MovieResponseDto toDto(Movie movie);
}
