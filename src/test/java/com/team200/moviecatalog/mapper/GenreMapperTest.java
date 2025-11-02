package com.team200.moviecatalog.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.genre.GenreRequestDto;
import com.team200.moviecatalog.dto.genre.GenreResponseDto;
import com.team200.moviecatalog.model.Genre;
import org.junit.jupiter.api.Test;

class GenreMapperTest {
    private static final String GENRE_NAME = "Drama";
    private final GenreMapper genreMapper = new GenreMapperImpl();

    @Test
    void shouldMapToEntity() {
        GenreRequestDto expected = new GenreRequestDto(GENRE_NAME);
        Genre result = genreMapper.toEntity(expected);
        assertThat(result.getName()).isEqualTo(GENRE_NAME);
    }

    @Test
    void shouldMapToDto() {
        Genre expected = new Genre();
        expected.setId(1L);
        expected.setName(GENRE_NAME);
        GenreResponseDto result = genreMapper.toDto(expected);
        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.name()).isEqualTo(GENRE_NAME);
    }
}
