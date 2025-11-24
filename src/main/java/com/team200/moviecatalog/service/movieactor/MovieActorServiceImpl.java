package com.team200.moviecatalog.service.movieactor;

import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.MovieActorMapper;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.movieactor.MovieActorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieActorServiceImpl implements MovieActorService {

    private static final String MOVIE_NOT_FOUND = "Movie not found: ";

    private final MovieActorRepository movieActorRepository;
    private final MovieRepository movieRepository;
    private final MovieActorMapper movieActorMapper;

    @Override
    public List<MovieActorDto> getCastByMovie(Long movieId) {
        if (!movieRepository.existsById(movieId)) {
            throw new EntityNotFoundException(MOVIE_NOT_FOUND + movieId);
        }

        return movieActorRepository.findAllByMovieId(movieId)
                .stream()
                .map(movieActorMapper::toDto)
                .toList();
    }
}
