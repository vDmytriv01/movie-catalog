package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AgeRatingSpecificationProvider implements SpecificationProvider<Movie> {
    @Override
    public String getKey() {
        return "ageRating";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        List<AgeRating> ratings = Arrays.stream(values)
                .map(AgeRating::valueOf)
                .toList();
        return (root, query, cb) -> root.get("ageRating").in(ratings);
    }
}
