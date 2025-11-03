package com.team200.moviecatalog.mapper;

import static com.team200.moviecatalog.util.TestEntityFactory.actor;
import static com.team200.moviecatalog.util.TestEntityFactory.country;
import static com.team200.moviecatalog.util.TestEntityFactory.director;
import static com.team200.moviecatalog.util.TestEntityFactory.genre;
import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.model.Actor;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import com.team200.moviecatalog.model.Country;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.model.Movie;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieMapperTest {

    private final MovieMapper movieMapper = new MovieMapperImpl();
    private Movie baseMovie;

    @BeforeEach
    void setUp() {
        baseMovie = Movie.builder()
                .id(1L)
                .title("Inception")
                .description("Mind-bending thriller")
                .releaseDate(LocalDate.of(2010, 7, 16))
                .year(2010)
                .duration(148)
                .posterUrl("poster.jpg")
                .trailerUrl("trailer.mp4")
                .averageRating(BigDecimal.valueOf(9.1))
                .genres(Set.of(genre(1L, "Sci-Fi"), genre(2L, "Thriller")))
                .directors(Set.of(director(1L, "Christopher Nolan")))
                .actors(Set.of(actor(1L, "Leonardo DiCaprio"), actor(2L,
                        "Joseph Gordon-Levitt")))
                .countries(Set.of(country(1L, "USA")))
                .ageRating(AgeRating.PG_13)
                .category(Category.MOVIE)
                .build();
    }

    @Test
    void shouldMapToShortDto() {
        MovieShortResponseDto dto = movieMapper.toShortDto(baseMovie);

        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.title()).isEqualTo("Inception");
        assertThat(dto.genres()).isEqualTo("Sci-Fi / Thriller");
        assertThat(dto.posterUrl()).isEqualTo("poster.jpg");
        assertThat(dto.averageRating()).isEqualTo(BigDecimal.valueOf(9.1));
        assertThat(dto.year()).isEqualTo(2010);
    }

    @Test
    void shouldMapToFullDto() {
        MovieFullResponseDto dto = movieMapper.toFullDto(baseMovie);

        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.title()).isEqualTo("Inception");
        assertThat(dto.directors()).containsExactly("Christopher Nolan");
        assertThat(dto.actors()).containsExactlyInAnyOrder("Leonardo DiCaprio",
                "Joseph Gordon-Levitt");
        assertThat(dto.genres()).containsExactlyInAnyOrder("Sci-Fi", "Thriller");
        assertThat(dto.countries()).containsExactly("USA");
    }

    @Test
    void shouldMapToResponseDto() {
        MovieResponseDto dto = movieMapper.toDto(baseMovie);

        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.title()).isEqualTo("Inception");
        assertThat(dto.averageRating()).isEqualTo(BigDecimal.valueOf(9.1));
        assertThat(dto.ageRating()).isEqualTo("PG_13");
        assertThat(dto.category()).isEqualTo("MOVIE");
    }

    @Test
    void shouldMapRequestDtoToEntity() {
        MovieRequestDto dto = new MovieRequestDto(
                "Dune",
                "Sci-fi masterpiece",
                LocalDate.of(2021, 10, 22),
                2021,
                155,
                Set.of(1L, 2L),
                BigDecimal.valueOf(8.5),
                "poster.png",
                "trailer.mp4",
                Set.of(3L),
                Set.of(4L, 5L),
                Set.of(6L, 7L),
                AgeRating.PG_13,
                Category.MOVIE
        );

        Movie entity = movieMapper.toEntity(dto);

        assertThat(entity.getTitle()).isEqualTo("Dune");
        assertThat(entity.getAverageRating()).isEqualTo(BigDecimal.valueOf(8.5));
        assertThat(entity.getCountries()).extracting(Country::getId)
                .containsExactlyInAnyOrder(1L, 2L);
        assertThat(entity.getDirectors()).extracting(Director::getId).containsExactly(3L);
        assertThat(entity.getGenres()).extracting(Genre::getId).containsExactlyInAnyOrder(4L, 5L);
        assertThat(entity.getActors()).extracting(Actor::getId).containsExactlyInAnyOrder(6L, 7L);
    }
}
