package com.team200.moviecatalog.service.moviewatchlink;

import com.team200.moviecatalog.dto.movie.MovieWatchLinkCreateRequest;
import com.team200.moviecatalog.dto.movie.MovieWatchLinkDto;
import java.util.List;

public interface MovieWatchLinkService {

    List<MovieWatchLinkDto> getWatchLinksForMovie(Long movieId);

    MovieWatchLinkDto addWatchLink(Long movieId, MovieWatchLinkCreateRequest request);
}
