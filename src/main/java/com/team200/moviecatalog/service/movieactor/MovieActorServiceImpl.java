package com.team200.moviecatalog.service.movieactor;

import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.mapper.MovieActorMapper;
import com.team200.moviecatalog.repository.movieactor.MovieActorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieActorServiceImpl implements MovieActorService {

    private final MovieActorRepository movieActorRepository;
    private final MovieActorMapper movieActorMapper;

    @Override
    public List<MovieActorDto> getCastByMovie(Long movieId) {
        return movieActorRepository.findAllByMovieId(movieId).stream()
                .map(movieActorMapper::toDto)
                .toList();
    }
}
