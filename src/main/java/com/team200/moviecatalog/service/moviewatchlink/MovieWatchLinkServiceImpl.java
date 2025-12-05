package com.team200.moviecatalog.service.moviewatchlink;

import com.team200.moviecatalog.dto.movie.MovieWatchLinkCreateRequest;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.MovieWatchLinkMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.MovieWatchLink;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.moviewatchlink.MovieWatchLinkRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieWatchLinkServiceImpl implements MovieWatchLinkService {

    private static final String MOVIE_NOT_FOUND = "Movie not found: ";

    private final MovieWatchLinkRepository movieWatchLinkRepository;
    private final MovieRepository movieRepository;
    private final MovieWatchLinkMapper movieWatchLinkMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MovieWatchLinkDto> getWatchLinksForMovie(Long movieId) {
        if (!movieRepository.existsById(movieId)) {
            throw new EntityNotFoundException(MOVIE_NOT_FOUND + movieId);
        }
        return movieWatchLinkRepository.findAllByMovieId(movieId)
                .stream()
                .map(movieWatchLinkMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public MovieWatchLinkDto addWatchLink(Long movieId, MovieWatchLinkCreateRequest request) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND + movieId));
        MovieWatchLink watchLink = movieWatchLinkMapper.toEntity(request, movie);
        MovieWatchLink saved = movieWatchLinkRepository.save(watchLink);
        return movieWatchLinkMapper.toDto(saved);
    }
}
