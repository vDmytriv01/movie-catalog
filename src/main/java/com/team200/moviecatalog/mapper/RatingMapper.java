package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.rating.RatingRequestDto;
import com.team200.moviecatalog.dto.rating.RatingResponseDto;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Rating;
import com.team200.moviecatalog.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CentralMapperConfig.class)
public interface RatingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movie", source = "movieId", qualifiedByName = "movieFromId")
    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    Rating toEntity(RatingRequestDto dto);

    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "userId", source = "user.id")
    RatingResponseDto toDto(Rating rating);

    @Named("movieFromId")
    default Movie movieFromId(Long id) {
        if (id == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }

    @Named("userFromId")
    default User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
