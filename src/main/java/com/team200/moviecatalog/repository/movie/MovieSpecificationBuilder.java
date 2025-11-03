package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationBuilder;
import com.team200.moviecatalog.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSpecificationBuilder
        implements SpecificationBuilder<Movie, MovieSearchParametersDto> {

    private static final String KEY_TITLE = "title";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_AGE_RATING = "ageRating";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_YEAR = "year";
    private static final String KEY_MIN_RATING = "minRating";

    private final SpecificationProviderManager<Movie> specificationProviderManager;

    @Override
    public Specification<Movie> build(MovieSearchParametersDto params) {
        Specification<Movie> spec = (root, query, cb) -> cb.conjunction();

        if (params.title() != null && !params.title().isBlank()) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_TITLE)
                    .buildSpecification(new String[]{params.title()}));
        }

        if (params.year() != null) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_YEAR)
                    .buildSpecification(new String[]{params.year().toString()}));
        }

        if (params.genre() != null && !params.genre().isBlank()) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_GENRE)
                    .buildSpecification(new String[]{params.genre()}));
        }

        if (params.ageRating() != null && !params.ageRating().isBlank()) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_AGE_RATING)
                    .buildSpecification(new String[]{params.ageRating()}));
        }

        if (params.category() != null && !params.category().isBlank()) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_CATEGORY)
                    .buildSpecification(new String[]{params.category()}));
        }

        if (params.minRating() != null) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_MIN_RATING)
                    .buildSpecification(new String[]{params.minRating().toString()}));
        }

        return spec;
    }
}
