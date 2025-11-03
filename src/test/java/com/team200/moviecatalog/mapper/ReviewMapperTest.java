package com.team200.moviecatalog.mapper;

import static com.team200.moviecatalog.util.TestEntityFactory.movieWithId;
import static com.team200.moviecatalog.util.TestEntityFactory.review;
import static com.team200.moviecatalog.util.TestEntityFactory.userWithId;
import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.review.ReviewRequestDto;
import com.team200.moviecatalog.dto.review.ReviewResponseDto;
import com.team200.moviecatalog.model.Review;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ReviewMapperTest {
    private static final String COMMENT = "Excellent cinematography!";
    private static final long MOVIE_ID = 5L;
    private static final long USER_ID = 9L;

    private final ReviewMapper reviewMapper = new ReviewMapperImpl();

    @Test
    void shouldMapToEntity() {
        ReviewRequestDto dto = new ReviewRequestDto(COMMENT, MOVIE_ID, USER_ID);

        Review actual = reviewMapper.toEntity(dto);
        Review expected = review(null, COMMENT, movieWithId(MOVIE_ID), userWithId(USER_ID));

        assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("id", "createdAt")
                .isEqualTo(expected);
    }

    @Test
    void shouldMapToDto() {
        Review review = review(1L, COMMENT, movieWithId(MOVIE_ID), userWithId(USER_ID));
        review.setCreatedAt(LocalDateTime.of(2025, 11, 2, 22, 30));

        ReviewResponseDto actual = reviewMapper.toDto(review);
        ReviewResponseDto expected = new ReviewResponseDto(
                1L,
                COMMENT,
                MOVIE_ID,
                USER_ID,
                LocalDateTime.of(2025, 11, 2, 22, 30)
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
