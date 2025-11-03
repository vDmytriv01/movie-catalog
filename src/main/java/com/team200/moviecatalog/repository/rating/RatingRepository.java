package com.team200.moviecatalog.repository.rating;

import com.team200.moviecatalog.model.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByMovieId(Long movieId);
}
