package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MinRatingSpecificationProvider implements SpecificationProvider<Movie> {
    @Override
    public String getKey() {
        return "minRating";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        Double rating = Double.parseDouble(values[0]);
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("averageRating"), rating);
    }
}
