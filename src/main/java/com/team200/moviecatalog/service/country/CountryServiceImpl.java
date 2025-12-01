package com.team200.moviecatalog.service.country;

import com.team200.moviecatalog.dto.country.CountryRequestDto;
import com.team200.moviecatalog.dto.country.CountryResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.CountryMapper;
import com.team200.moviecatalog.model.Country;
import com.team200.moviecatalog.repository.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_NOT_FOUND = "Country not found: ";
    private static final String COUNTRY_EXISTS = "Country already exists: ";

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public CountryResponseDto create(CountryRequestDto dto) {
        if (countryRepository.existsByNameIgnoreCase(dto.name())) {
            throw new ConflictException(COUNTRY_EXISTS + dto.name());
        }

        Country country = countryMapper.toEntity(dto);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public CountryResponseDto getById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(COUNTRY_NOT_FOUND + id));
        return countryMapper.toDto(country);
    }

    @Override
    public Page<CountryResponseDto> getAll(Pageable pageable) {
        return countryRepository.findAll(pageable)
                .map(countryMapper::toDto);
    }

    @Override
    public CountryResponseDto update(Long id, CountryRequestDto dto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(COUNTRY_NOT_FOUND + id));

        if (!country.getName().equalsIgnoreCase(dto.name())
                && countryRepository.existsByNameIgnoreCase(dto.name())) {
            throw new ConflictException(COUNTRY_EXISTS + dto.name());
        }

        country.setName(dto.name());
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public void delete(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(COUNTRY_NOT_FOUND + id));
        countryRepository.delete(country);
    }
}
