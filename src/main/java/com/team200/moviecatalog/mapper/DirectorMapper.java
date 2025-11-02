package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.director.DirectorRequestDto;
import com.team200.moviecatalog.dto.director.DirectorResponseDto;
import com.team200.moviecatalog.model.Director;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface DirectorMapper {
    DirectorResponseDto toDto(Director director);

    Director toEntity(DirectorRequestDto dto);
}
