package com.team200.moviecatalog.dto.movieactor;

import com.team200.moviecatalog.dto.actor.ActorResponseDto;

public record MovieActorDto(
        Long id,
        ActorResponseDto actor
) {
}
