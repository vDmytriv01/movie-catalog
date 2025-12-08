package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Season;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
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
            LEFT JOIN FETCH m.countries
            WHERE m.id = :id
            """)
    Optional<Movie> findByIdWithAll(@Param("id") Long id);

    Page<Movie> findAllByOrderByAverageRatingDesc(Pageable pageable);

    Page<Movie> findAllBySeasonOrderByAverageRatingDesc(Season season, Pageable pageable);

    boolean existsByTitleIgnoreCase(String title);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = """
            UPDATE movies m
            SET m.average_rating = (
                SELECT COALESCE(ROUND(AVG(r.value), 2), 0)
                FROM ratings r
                WHERE r.movie_id = :movieId
            ),
                m.rating_count = (
                SELECT COUNT(*)
                FROM ratings r
                WHERE r.movie_id = :movieId
            )
            WHERE m.id = :movieId
            """, nativeQuery = true)
    void updateRatingAggregates(@Param("movieId") Long movieId);
}
