package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkCreateRequest;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkDto;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.MovieWatchLink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CentralMapperConfig.class)
public interface MovieWatchLinkMapper {

    MovieWatchLinkDto toDto(MovieWatchLink entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movie", source = "movie")
    MovieWatchLink toEntity(MovieWatchLinkCreateRequest request, Movie movie);
}
