package com.team200.moviecatalog.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.country.CountryRequestDto;
import com.team200.moviecatalog.dto.country.CountryResponseDto;
import com.team200.moviecatalog.model.Country;
import org.junit.jupiter.api.Test;

class CountryMapperTest {
    private static final String COUNTRY_NAME = "Ukraine";
    private final CountryMapper countryMapper = new CountryMapperImpl();

    @Test
    void shouldMapToEntity() {
        CountryRequestDto expected = new CountryRequestDto(COUNTRY_NAME);
        Country result = countryMapper.toEntity(expected);
        assertThat(result.getName()).isEqualTo(COUNTRY_NAME);
    }

    @Test
    void shouldMapToDto() {
        Country expected = new Country();
        expected.setId(1L);
        expected.setName(COUNTRY_NAME);
        CountryResponseDto result = countryMapper.toDto(expected);
        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.name()).isEqualTo(COUNTRY_NAME);
    }
}
