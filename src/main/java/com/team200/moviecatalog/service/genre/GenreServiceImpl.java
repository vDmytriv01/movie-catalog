package com.team200.moviecatalog.service.genre;

import com.team200.moviecatalog.dto.genre.GenreRequestDto;
import com.team200.moviecatalog.dto.genre.GenreResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.GenreMapper;
import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.repository.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private static final String GENRE_NOT_FOUND = "Genre not found: ";
    private static final String GENRE_EXISTS = "Genre already exists: ";

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreResponseDto create(GenreRequestDto dto) {

        if (genreRepository.existsByNameIgnoreCase(dto.name())) {
            throw new ConflictException(GENRE_EXISTS + dto.name());
        }

        Genre genre = genreMapper.toEntity(dto);
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public GenreResponseDto getById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(GENRE_NOT_FOUND + id));
        return genreMapper.toDto(genre);
    }

    @Override
    public Page<GenreResponseDto> getAll(Pageable pageable) {
        return genreRepository.findAll(pageable)
                .map(genreMapper::toDto);
    }

    @Override
    public GenreResponseDto update(Long id, GenreRequestDto dto) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(GENRE_NOT_FOUND + id));

        if (!genre.getName().equalsIgnoreCase(dto.name())
                && genreRepository.existsByNameIgnoreCase(dto.name())) {
            throw new ConflictException(GENRE_EXISTS + dto.name());
        }

        genre.setName(dto.name());
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public void delete(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(GENRE_NOT_FOUND + id));

        genreRepository.delete(genre);
    }
}
