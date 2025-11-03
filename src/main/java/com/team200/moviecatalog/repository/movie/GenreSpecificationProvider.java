package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GenreSpecificationProvider implements SpecificationProvider<Movie> {
    @Override
    public String getKey() {
        return "genre";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        String genreName = values[0];
        return (root, query, cb) -> {
            query.distinct(true);
            Join<Movie, Genre> join = root.join("genres", JoinType.LEFT);
            return cb.equal(cb.lower(join.get("name")), genreName.toLowerCase());
        };
    }
}
