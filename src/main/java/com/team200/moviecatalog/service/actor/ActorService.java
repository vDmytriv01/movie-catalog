package com.team200.moviecatalog.service.actor;

import com.team200.moviecatalog.dto.actor.ActorRequestDto;
import com.team200.moviecatalog.dto.actor.ActorResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActorService {
    ActorResponseDto create(ActorRequestDto dto);

    ActorResponseDto getById(Long id);

    Page<ActorResponseDto> getAll(Pageable pageable);

    ActorResponseDto update(Long id, ActorRequestDto dto);

    void delete(Long id);
}
