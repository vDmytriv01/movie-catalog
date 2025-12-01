package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.genre.GenreRequestDto;
import com.team200.moviecatalog.dto.genre.GenreResponseDto;
import com.team200.moviecatalog.service.genre.GenreService;
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
@RequestMapping("/genres")
@RequiredArgsConstructor
@Validated
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/{id}")
    public GenreResponseDto getById(@PathVariable @Positive Long id) {
        return genreService.getById(id);
    }

    @GetMapping
    public Page<GenreResponseDto> getAll(Pageable pageable) {
        return genreService.getAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreResponseDto create(@RequestBody @Valid GenreRequestDto dto) {
        return genreService.create(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public GenreResponseDto update(@PathVariable @Positive Long id,
                                   @RequestBody @Valid GenreRequestDto dto) {
        return genreService.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        genreService.delete(id);
    }
}
