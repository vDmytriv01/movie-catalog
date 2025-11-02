package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.actor.ActorRequestDto;
import com.team200.moviecatalog.dto.actor.ActorResponseDto;
import com.team200.moviecatalog.model.Actor;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface ActorMapper {
    ActorResponseDto toDto(Actor actor);

    Actor toEntity(ActorRequestDto dto);
}
