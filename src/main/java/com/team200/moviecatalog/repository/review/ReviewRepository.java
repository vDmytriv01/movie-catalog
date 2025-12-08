package com.team200.moviecatalog.repository.review;

import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.repository.review.projection.FeedbackProjection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);

    Optional<Review> findByMovieIdAndUserId(Long movieId, Long userId);

    boolean existsByMovieIdAndUserId(Long movieId, Long userId);

    @Query("""
            SELECT r.id AS reviewId,
                   r.movie.id AS movieId,
                   rt.value AS rating,
                   r.comment AS comment,
                   u.nickname AS nickname,
                   r.createdAt AS createdAt
            FROM Review r
            JOIN r.user u
            JOIN Rating rt ON rt.movie = r.movie AND rt.user = u
            WHERE r.movie.id = :movieId
            """)
    List<FeedbackProjection> findFeedbackDetailsByMovieId(@Param("movieId") Long movieId);
}
