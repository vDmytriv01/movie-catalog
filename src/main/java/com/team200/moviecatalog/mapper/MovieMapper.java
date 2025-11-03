package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.model.Actor;
import com.team200.moviecatalog.model.Country;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.model.Movie;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CentralMapperConfig.class)
public interface MovieMapper {

    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToString")
    MovieShortResponseDto toShortDto(Movie movie);

    @Mapping(target = "directors", source = "directors", qualifiedByName = "entityNames")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "entityNames")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "entityNames")
    @Mapping(target = "countries", source = "countries", qualifiedByName = "entityNames")
    MovieFullResponseDto toFullDto(Movie movie);

    @Mapping(target = "countries", source = "countryIds", qualifiedByName = "toCountries")
    @Mapping(target = "directors", source = "directorIds", qualifiedByName = "toDirectors")
    @Mapping(target = "genres", source = "genreIds", qualifiedByName = "toGenres")
    @Mapping(target = "actors", source = "actorIds", qualifiedByName = "toActors")
    Movie toEntity(MovieRequestDto dto);

    @Mapping(target = "countries", source = "countries", qualifiedByName = "entityNames")
    @Mapping(target = "directors", source = "directors", qualifiedByName = "entityNames")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "entityNames")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "entityNames")
    @Mapping(target = "ageRating", source = "ageRating", qualifiedByName = "enumToString")
    @Mapping(target = "category", source = "category", qualifiedByName = "enumToString")
    MovieResponseDto toDto(Movie movie);

    @Named("entityNames")
    default Set<String> toEntityNames(Set<?> entities) {
        if (entities == null) {
            return Set.of();
        }
        return entities.stream()
                .map(e -> {
                    try {
                        return (String) e.getClass().getMethod("getName").invoke(e);
                    } catch (Exception ex) {
                        try {
                            return (String) e.getClass()
                                    .getMethod("getFullName")
                                    .invoke(e);
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
        return toEntityNames(genres).stream()
                .collect(Collectors.joining(" / "));
    }

    @Named("enumToString")
    default String enumToString(Enum<?> e) {
        return e != null ? e.name() : null;
    }

    @Named("toCountries")
    default Set<Country> toCountries(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream()
                .map(id -> new Country(id, null))
                .collect(Collectors.toSet());
    }

    @Named("toDirectors")
    default Set<Director> toDirectors(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream().map(id -> {
            Director d = new Director();
            d.setId(id);
            return d;
        }).collect(Collectors.toSet());
    }

    @Named("toActors")
    default Set<Actor> toActors(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream().map(id -> {
            Actor a = new Actor();
            a.setId(id);
            return a;
        }).collect(Collectors.toSet());
    }

    @Named("toGenres")
    default Set<Genre> toGenres(Set<Long> ids) {
        if (ids == null) {
            return Set.of();
        }
        return ids.stream()
                .map(id -> new Genre(id, null))
                .collect(Collectors.toSet());
    }
}
