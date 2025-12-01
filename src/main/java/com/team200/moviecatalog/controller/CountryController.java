package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.country.CountryRequestDto;
import com.team200.moviecatalog.dto.country.CountryResponseDto;
import com.team200.moviecatalog.service.country.CountryService;
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
@RequestMapping("/countries")
@RequiredArgsConstructor
@Validated
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/{id}")
    public CountryResponseDto getById(@PathVariable @Positive Long id) {
        return countryService.getById(id);
    }

    @GetMapping
    public Page<CountryResponseDto> getAll(Pageable pageable) {
        return countryService.getAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryResponseDto create(@RequestBody @Valid CountryRequestDto dto) {
        return countryService.create(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public CountryResponseDto update(@PathVariable @Positive Long id,
                                     @RequestBody @Valid CountryRequestDto dto) {
        return countryService.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive Long id) {
        countryService.delete(id);
    }
}
