package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.actor.ActorRequestDto;
import com.team200.moviecatalog.dto.actor.ActorResponseDto;
import com.team200.moviecatalog.service.actor.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActorResponseDto create(@RequestBody @Valid ActorRequestDto dto) {
        return actorService.create(dto);
    }

    @GetMapping("/{id}")
    public ActorResponseDto getById(@PathVariable Long id) {
        return actorService.getById(id);
    }

    @GetMapping
    public Page<ActorResponseDto> getAll(Pageable pageable) {
        return actorService.getAll(pageable);
    }

    @PutMapping("/{id}")
    public ActorResponseDto update(@PathVariable Long id,
                                   @RequestBody @Valid ActorRequestDto dto) {
        return actorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        actorService.delete(id);
    }
}
