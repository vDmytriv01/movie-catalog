package com.team200.moviecatalog.service.director;

import com.team200.moviecatalog.dto.director.DirectorRequestDto;
import com.team200.moviecatalog.dto.director.DirectorResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.DirectorMapper;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.repository.director.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private static final String DIRECTOR_NOT_FOUND = "Director not found: ";
    private static final String DIRECTOR_EXISTS = "Director already exists: ";

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public DirectorResponseDto create(DirectorRequestDto dto) {
        if (directorRepository.existsByFullNameIgnoreCase(dto.fullName())) {
            throw new ConflictException(DIRECTOR_EXISTS + dto.fullName());
        }

        Director director = directorMapper.toEntity(dto);
        return directorMapper.toDto(directorRepository.save(director));
    }

    @Override
    public DirectorResponseDto getById(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DIRECTOR_NOT_FOUND + id));
        return directorMapper.toDto(director);
    }

    @Override
    public Page<DirectorResponseDto> getAll(Pageable pageable) {
        return directorRepository.findAll(pageable)
                .map(directorMapper::toDto);
    }

    @Override
    public DirectorResponseDto update(Long id, DirectorRequestDto dto) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DIRECTOR_NOT_FOUND + id));

        if (!director.getFullName().equalsIgnoreCase(dto.fullName())
                && directorRepository.existsByFullNameIgnoreCase(dto.fullName())) {
            throw new ConflictException(DIRECTOR_EXISTS + dto.fullName());
        }

        director.setFullName(dto.fullName());
        return directorMapper.toDto(directorRepository.save(director));
    }

    @Override
    public void delete(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DIRECTOR_NOT_FOUND + id));

        directorRepository.delete(director);
    }
}
