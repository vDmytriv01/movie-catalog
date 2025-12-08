package com.team200.moviecatalog.repository.rating;

import com.team200.moviecatalog.model.Rating;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);

    @Query("""
            SELECT r.value FROM Rating r
            WHERE r.movie.id = :movieId AND r.user.id = :userId
            """)
    Integer findValueByMovieAndUser(@Param("movieId") Long movieId,
                                    @Param("userId") Long userId);

    @Query("""
            SELECT r.value FROM Rating r
            WHERE r.movie.id = :movieId
            """)
    List<Integer> findAllValuesByMovieId(@Param("movieId") Long movieId);
}
