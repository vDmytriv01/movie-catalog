package com.team200.moviecatalog.service.movieactor;

import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.mapper.MovieActorMapper;
import com.team200.moviecatalog.model.Actor;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.MovieActor;
import com.team200.moviecatalog.repository.actor.ActorRepository;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.movieactor.MovieActorRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieActorServiceImpl implements MovieActorService {

    private static final String MOVIE_NOT_FOUND = "Movie not found: ";
    private static final String ACTOR_NOT_FOUND = "Actor not found: ";

    private final MovieActorRepository movieActorRepository;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
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

    @Override
    @Transactional
    public void createCast(Long movieId, Collection<Long> actorIds) {
        if (actorIds == null || actorIds.isEmpty()) {
            return;
        }
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND + movieId));

        List<Actor> actors = actorRepository.findAllById(actorIds);
        if (actors.size() != actorIds.size()) {
            Set<Long> foundIds = actors.stream().map(Actor::getId).collect(Collectors.toSet());
            Long missing = actorIds.stream().filter(
                    id -> !foundIds.contains(id)).findFirst().orElse(null);
            throw new EntityNotFoundException(ACTOR_NOT_FOUND + missing);
        }

        List<MovieActor> links = actors.stream()
                .map(actor -> MovieActor.builder()
                        .movie(movie)
                        .actor(actor)
                        .build())
                .toList();
        movieActorRepository.saveAll(links);
    }

    @Override
    @Transactional
    public void updateCast(Long movieId, Collection<Long> actorIds) {
        movieActorRepository.deleteByMovieId(movieId);
        createCast(movieId, actorIds);
    }
}
