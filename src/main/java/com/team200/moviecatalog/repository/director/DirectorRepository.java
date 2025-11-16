package com.team200.moviecatalog.repository.director;

import com.team200.moviecatalog.model.Director;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findAllByMovies_Id(Long movieId);
}
