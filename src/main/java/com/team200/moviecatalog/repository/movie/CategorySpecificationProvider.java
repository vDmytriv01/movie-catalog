package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CategorySpecificationProvider implements SpecificationProvider<Movie> {

    @Override
    public String getKey() {
        return "categories";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        return (root, query, cb) -> root.get("category").in((Object[]) values);
    }
}
