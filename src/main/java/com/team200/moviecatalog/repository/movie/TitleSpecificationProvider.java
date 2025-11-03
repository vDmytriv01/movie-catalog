package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Movie> {

    @Override
    public String getKey() {
        return "title";
    }

    @Override
    public Specification<Movie> buildSpecification(String[] values) {
        String keyword = values[0].toLowerCase();
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("title")), "%" + keyword + "%");
    }
}
