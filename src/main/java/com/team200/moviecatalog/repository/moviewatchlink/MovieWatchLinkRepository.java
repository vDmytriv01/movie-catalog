package com.team200.moviecatalog.repository.moviewatchlink;

import com.team200.moviecatalog.model.MovieWatchLink;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieWatchLinkRepository extends JpaRepository<MovieWatchLink, Long> {

    List<MovieWatchLink> findAllByMovieId(Long movieId);
}
