package com.team200.moviecatalog.service.genre;

import com.team200.moviecatalog.dto.genre.GenreRequestDto;
import com.team200.moviecatalog.dto.genre.GenreResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenreService {
    GenreResponseDto create(GenreRequestDto dto);

    GenreResponseDto getById(Long id);

    Page<GenreResponseDto> getAll(Pageable pageable);

    GenreResponseDto update(Long id, GenreRequestDto dto);

    void delete(Long id);
}
