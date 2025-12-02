package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.model.Country;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.model.Movie;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = CentralMapperConfig.class)
public interface MovieMapper {

    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToString")
    MovieShortResponseDto toShortDto(Movie movie);

    @Mapping(target = "genres", source = "genres", qualifiedByName = "entityNames")
    @Mapping(target = "countries", source = "countries", qualifiedByName = "entityNames")
    MovieResponseDto toResponseDto(Movie movie);

    @Mapping(target = "genres", source = "movie.genres", qualifiedByName = "entityNames")
    @Mapping(target = "countries", source = "movie.countries", qualifiedByName = "entityNames")
    @Mapping(target = "directors", source = "directors")
    MovieFullResponseDto toFullDto(Movie movie, Set<String> directors);

    @Mapping(target = "countries", source = "countryIds", qualifiedByName = "toCountries")
    @Mapping(target = "genres", source = "genreIds", qualifiedByName = "toGenres")
    @Mapping(target = "directors", source = "directorIds", qualifiedByName = "toDirectors")
    Movie toEntity(MovieRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "countries", source = "countryIds", qualifiedByName = "toCountries")
    @Mapping(target = "genres", source = "genreIds", qualifiedByName = "toGenres")
    @Mapping(target = "directors", source = "directorIds", qualifiedByName = "toDirectors")
    void updateMovieFromDto(MovieRequestDto dto, @MappingTarget Movie movie);

    @Named("entityNames")
    default Set<String> toEntityNames(Set<?> entities) {
        if (entities == null || entities.isEmpty()) {
            return Set.of();
        }
        return entities.stream()
                .map(e -> {
                    try {
                        return (String) e.getClass().getMethod("getName").invoke(e);
                    } catch (Exception ex) {
                        try {
                            return (String) e.getClass().getMethod("getFullName").invoke(e);
                        } catch (Exception ignored) {
                            return null;
                        }
                    }
                })
                .filter(n -> n != null && !n.isBlank())
                .collect(Collectors.toSet());
    }

    @Named("genresToString")
    default String genresToString(Set<?> genres) {
        return toEntityNames(genres).stream().collect(Collectors.joining(" / "));
    }

    @Named("toCountries")
    default Set<Country> toCountries(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream().map(id -> new Country(id, null)).collect(Collectors.toSet());
    }

    @Named("toGenres")
    default Set<Genre> toGenres(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream().map(id -> new Genre(id, null)).collect(Collectors.toSet());
    }

    @Named("toDirectors")
    default Set<Director> toDirectors(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream().map(id -> {
            Director director = new Director();
            director.setId(id);
            return director;
        }).collect(Collectors.toSet());
    }
}
