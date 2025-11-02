package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.genre.GenreRequestDto;
import com.team200.moviecatalog.dto.genre.GenreResponseDto;
import com.team200.moviecatalog.model.Genre;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface GenreMapper {
    GenreResponseDto toDto(Genre genre);

    Genre toEntity(GenreRequestDto dto);
}
