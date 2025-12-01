package com.team200.moviecatalog.service.director;

import com.team200.moviecatalog.dto.director.DirectorRequestDto;
import com.team200.moviecatalog.dto.director.DirectorResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DirectorService {
    DirectorResponseDto create(DirectorRequestDto dto);

    DirectorResponseDto getById(Long id);

    Page<DirectorResponseDto> getAll(Pageable pageable);

    DirectorResponseDto update(Long id, DirectorRequestDto dto);

    void delete(Long id);
}
