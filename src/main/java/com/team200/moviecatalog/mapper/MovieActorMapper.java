package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.model.MovieActor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CentralMapperConfig.class, uses = ActorMapper.class)
public interface MovieActorMapper {

    @Mapping(target = "actor", source = "actor")
    MovieActorDto toDto(MovieActor entity);
}
