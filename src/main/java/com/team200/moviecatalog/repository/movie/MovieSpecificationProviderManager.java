package com.team200.moviecatalog.repository.movie;

import com.team200.moviecatalog.exception.BadRequestException;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.SpecificationProvider;
import com.team200.moviecatalog.repository.SpecificationProviderManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MovieSpecificationProviderManager implements SpecificationProviderManager<Movie> {

    private static final String UNSUPPORTED_FILTER = "Unsupported filter: %s";

    private final Map<String, SpecificationProvider<Movie>> providers;

    public MovieSpecificationProviderManager(List<SpecificationProvider<Movie>> providers) {
        this.providers = providers.stream()
                .collect(Collectors.toMap(SpecificationProvider::getKey, p -> p));
    }

    @Override
    public SpecificationProvider<Movie> getSpecificationProvider(String key) {
        SpecificationProvider<Movie> provider = providers.get(key);
        if (provider == null) {
            throw new BadRequestException(String.format(UNSUPPORTED_FILTER, key));
        }
        return provider;
    }
}
