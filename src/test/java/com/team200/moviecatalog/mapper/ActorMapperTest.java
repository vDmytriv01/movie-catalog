package com.team200.moviecatalog.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.team200.moviecatalog.dto.actor.ActorRequestDto;
import com.team200.moviecatalog.dto.actor.ActorResponseDto;
import com.team200.moviecatalog.model.Actor;
import org.junit.jupiter.api.Test;

class ActorMapperTest {
    private static final String ACTOR_NAME = "Tom Hardy";
    private final ActorMapper actorMapper = new ActorMapperImpl();

    @Test
    void shouldMapToEntity() {
        ActorRequestDto expected = new ActorRequestDto(ACTOR_NAME);
        Actor result = actorMapper.toEntity(expected);
        assertThat(result.getFullName()).isEqualTo(ACTOR_NAME);
    }

    @Test
    void shouldMapToDto() {
        Actor expected = new Actor();
        expected.setId(1L);
        expected.setFullName(ACTOR_NAME);
        ActorResponseDto result = actorMapper.toDto(expected);
        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.fullName()).isEqualTo(ACTOR_NAME);
    }
}
