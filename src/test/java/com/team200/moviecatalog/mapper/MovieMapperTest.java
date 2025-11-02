package com.team200.moviecatalog.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import com.team200.moviecatalog.model.Movie;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class MovieMapperTest {

    private final MovieMapper mapper = new MovieMapperImpl();

    @Test
    void shouldMapToEntity() {
        // given
        MovieRequestDto dto = new MovieRequestDto(
                "Inception",
                "A thief who steals corporate secrets through dream-sharing technology.",
                LocalDate.of(2010, 7, 16),
                2010,
                148,
                BigDecimal.valueOf(8.8),
                "poster.jpg",
                "trailer.mp4",
                AgeRating.PG_13,
                Category.FILM
        );

        // when
        Movie movie = mapper.toEntity(dto);

        // then
        assertThat(movie.getTitle()).isEqualTo("Inception");
        assertThat(movie.getDescription()).contains("dream-sharing");
        assertThat(movie.getReleaseDate()).isEqualTo(LocalDate.of(2010, 7, 16));
        assertThat(movie.getAverageRating()).isEqualByComparingTo(BigDecimal.valueOf(8.8));
        assertThat(movie.getAgeRating()).isEqualTo(AgeRating.PG_13);
        assertThat(movie.getCategory()).isEqualTo(Category.FILM);
    }

    @Test
    void shouldMapToDto() {
        // given
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Oppenheimer");
        movie.setDescription("Story of J. Robert Oppenheimer");
        movie.setReleaseDate(LocalDate.of(2023, 7, 21));
        movie.setYear(2023);
        movie.setDuration(180);
        movie.setAverageRating(BigDecimal.valueOf(9.0));
        movie.setPosterUrl("poster.png");
        movie.setTrailerUrl("trailer.mov");
        movie.setAgeRating(AgeRating.R);
        movie.setCategory(Category.FILM);

        // when
        MovieResponseDto dto = mapper.toDto(movie);

        // then
        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.title()).isEqualTo("Oppenheimer");
        assertThat(dto.year()).isEqualTo(2023);
        assertThat(dto.averageRating()).isEqualByComparingTo("9.0");
        assertThat(dto.ageRating()).isEqualTo("R");
        assertThat(dto.category()).isEqualTo("FILM");
    }
}
