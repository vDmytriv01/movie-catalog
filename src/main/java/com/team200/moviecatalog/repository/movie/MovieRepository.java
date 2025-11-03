package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>,
        JpaSpecificationExecutor<Movie> {

    @Query("""
            SELECT DISTINCT m FROM Movie m
            LEFT JOIN FETCH m.directors
            LEFT JOIN FETCH m.genres
            LEFT JOIN FETCH m.actors
            LEFT JOIN FETCH m.countries
            WHERE m.id = :id
            """)
    Optional<Movie> findByIdWithAll(@Param("id") Long id);
}
