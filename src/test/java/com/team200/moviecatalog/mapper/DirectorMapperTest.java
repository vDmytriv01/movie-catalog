package com.team200.moviecatalog.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.director.DirectorRequestDto;
import com.team200.moviecatalog.dto.director.DirectorResponseDto;
import com.team200.moviecatalog.model.Director;
import org.junit.jupiter.api.Test;

class DirectorMapperTest {
    private static final String DIRECTOR_NAME = "Christopher Nolan";
    private final DirectorMapper directorMapper = new DirectorMapperImpl();

    @Test
    void shouldMapToEntity() {
        DirectorRequestDto expected = new DirectorRequestDto(DIRECTOR_NAME);
        Director result = directorMapper.toEntity(expected);
        assertThat(result.getFullName()).isEqualTo(DIRECTOR_NAME);
    }

    @Test
    void shouldMapToDto() {
        Director expected = new Director();
        expected.setId(1L);
        expected.setFullName(DIRECTOR_NAME);
        DirectorResponseDto result = directorMapper.toDto(expected);
        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.fullName()).isEqualTo(DIRECTOR_NAME);
    }
}
