package com.team200.moviecatalog.repository.movieactor;

import com.team200.moviecatalog.model.MovieActor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {

    @Query("""
                SELECT ma FROM MovieActor ma
                JOIN FETCH ma.actor
                WHERE ma.movie.id = :movieId
                ORDER BY ma.actor.fullName ASC
            """)
    List<MovieActor> findAllByMovieId(@Param("movieId") Long movieId);

    @Modifying
    @Query("DELETE FROM MovieActor ma WHERE ma.movie.id = :movieId")
    void deleteByMovieId(@Param("movieId") Long movieId);
}
