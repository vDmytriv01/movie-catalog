package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.country.CountryRequestDto;
import com.team200.moviecatalog.dto.country.CountryResponseDto;
import com.team200.moviecatalog.model.Country;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface CountryMapper {
    CountryResponseDto toDto(Country country);

    Country toEntity(CountryRequestDto dto);
}
