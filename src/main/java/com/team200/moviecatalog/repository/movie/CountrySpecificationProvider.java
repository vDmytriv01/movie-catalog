package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CountrySpecificationProvider implements SpecificationProvider<Movie> {
    @Override
    public String getKey() {
        return "countries";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        return (root, query, cb) -> {
            query.distinct(true);
            var join = root.join("countries", JoinType.LEFT);
            return join.get("name").in((Object[]) values);
        };
    }
}
