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
    private static final String KEY_GENRES = "genres";
    private static final String KEY_COUNTRIES = "countries";
    private static final String KEY_AGE_RATINGS = "ageRatings";
    private static final String KEY_CATEGORIES = "categories";

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
            spec = spec.and((root, query, cb) -> cb.equal(root.get("year"), params.year()));
        }

        if (params.genres() != null && params.genres().length > 0) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_GENRES)
                    .buildSpecification(params.genres()));
        }

        if (params.countries() != null && params.countries().length > 0) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_COUNTRIES)
                    .buildSpecification(params.countries()));
        }

        if (params.ageRatings() != null && params.ageRatings().length > 0) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_AGE_RATINGS)
                    .buildSpecification(params.ageRatings()));
        }

        if (params.categories() != null && params.categories().length > 0) {
            spec = spec.and(specificationProviderManager
                    .getSpecificationProvider(KEY_CATEGORIES)
                    .buildSpecification(params.categories()));
        }

        if (params.minRating() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("averageRating"), params.minRating()));
        }

        return spec;
    }
}
