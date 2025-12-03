package com.team200.moviecatalog.service.movieactor;

import com.team200.moviecatalog.dto.movieactor.MovieActorDto;
import java.util.Collection;
import java.util.List;

public interface MovieActorService {
    List<MovieActorDto> getCastByMovie(Long movieId);

    void createCast(Long movieId, Collection<Long> actorIds);

    void updateCast(Long movieId, Collection<Long> actorIds);
}
