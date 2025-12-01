package com.team200.moviecatalog.service.country;

import com.team200.moviecatalog.dto.country.CountryRequestDto;
import com.team200.moviecatalog.dto.country.CountryResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    CountryResponseDto create(CountryRequestDto dto);

    CountryResponseDto getById(Long id);

    Page<CountryResponseDto> getAll(Pageable pageable);

    CountryResponseDto update(Long id, CountryRequestDto dto);

    void delete(Long id);
}
