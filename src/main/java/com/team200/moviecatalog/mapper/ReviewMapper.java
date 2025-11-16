package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.review.ReviewRequestDto;
import com.team200.moviecatalog.dto.review.ReviewResponseDto;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CentralMapperConfig.class)
public interface ReviewMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movie", source = "movieId", qualifiedByName = "movieFromId")
    Review toEntity(ReviewRequestDto dto);

    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "userNickname", source = "user.nickname")
    ReviewResponseDto toDto(Review review);

    @Named("movieFromId")
    default Movie movieFromId(Long id) {
        if (id == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }
}
