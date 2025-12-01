package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.director.DirectorRequestDto;
import com.team200.moviecatalog.dto.director.DirectorResponseDto;
import com.team200.moviecatalog.service.director.DirectorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/directors")
@RequiredArgsConstructor
@Validated
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/{id}")
    public DirectorResponseDto getById(@PathVariable @Positive Long id) {
        return directorService.getById(id);
    }

    @GetMapping
    public Page<DirectorResponseDto> getAll(Pageable pageable) {
        return directorService.getAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorResponseDto create(@RequestBody @Valid DirectorRequestDto dto) {
        return directorService.create(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public DirectorResponseDto update(@PathVariable @Positive Long id,
                                      @RequestBody @Valid DirectorRequestDto dto) {
        return directorService.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        directorService.delete(id);
    }
}
