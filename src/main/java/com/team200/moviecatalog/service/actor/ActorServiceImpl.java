package com.team200.moviecatalog.service.actor;

import com.team200.moviecatalog.dto.actor.ActorRequestDto;
import com.team200.moviecatalog.dto.actor.ActorResponseDto;
import com.team200.moviecatalog.mapper.ActorMapper;
import com.team200.moviecatalog.model.Actor;
import com.team200.moviecatalog.repository.actor.ActorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public ActorResponseDto create(ActorRequestDto dto) {
        Actor actor = actorMapper.toEntity(dto);
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public ActorResponseDto getById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found: " + id));
        return actorMapper.toDto(actor);
    }

    @Override
    public Page<ActorResponseDto> getAll(Pageable pageable) {
        return actorRepository.findAll(pageable)
                .map(actorMapper::toDto);
    }

    @Override
    public ActorResponseDto update(Long id, ActorRequestDto dto) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found: " + id));
        actor.setFullName(dto.fullName());
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public void delete(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found: " + id));
        actorRepository.delete(actor);
    }
}
