package com.team200.moviecatalog.mapper;

import static com.team200.moviecatalog.util.TestEntityFactory.movieWithId;
import static com.team200.moviecatalog.util.TestEntityFactory.rating;
import static com.team200.moviecatalog.util.TestEntityFactory.userWithId;
import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.rating.RatingRequestDto;
import com.team200.moviecatalog.dto.rating.RatingResponseDto;
import com.team200.moviecatalog.model.Rating;
import org.junit.jupiter.api.Test;

class RatingMapperTest {
    private static final int VALUE = 8;
    private static final long MOVIE_ID = 2L;
    private static final long USER_ID = 3L;

    private final RatingMapper ratingMapper = new RatingMapperImpl();

    @Test
    void shouldMapToEntity() {
        RatingRequestDto dto = new RatingRequestDto(VALUE, MOVIE_ID, USER_ID);

        Rating actual = ratingMapper.toEntity(dto);
        Rating expected = rating(null, VALUE, movieWithId(MOVIE_ID), userWithId(USER_ID));

        assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expected);
    }

    @Test
    void shouldMapToDto() {
        Rating rating = rating(1L, VALUE, movieWithId(MOVIE_ID), userWithId(USER_ID));

        RatingResponseDto actual = ratingMapper.toDto(rating);
        RatingResponseDto expected = new RatingResponseDto(1L, VALUE, MOVIE_ID, USER_ID);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
