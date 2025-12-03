package com.team200.moviecatalog.service.movie;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.mapper.MovieMapper;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.model.Genre;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Season;
import com.team200.moviecatalog.repository.director.DirectorRepository;
import com.team200.moviecatalog.repository.genre.GenreRepository;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.movie.MovieSpecificationBuilder;
import com.team200.moviecatalog.service.movieactor.MovieActorService;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private static final String MOVIE_NOT_FOUND = "Movie not found: ";

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final DirectorRepository directorRepository;
    private final MovieMapper movieMapper;
    private final MovieSpecificationBuilder movieSpecificationBuilder;
    private final MovieActorService movieActorService;

    @Override
    @Transactional
    public MovieResponseDto createMovie(MovieRequestDto dto) {
        Movie movie = movieMapper.toEntity(dto);
        enrichMovieWithDateData(movie);
        movieRepository.save(movie);
        movieActorService.createCast(movie.getId(), dto.actorIds());
        return movieMapper.toResponseDto(movie);
    }

    @Override
    @Transactional
    public MovieResponseDto updateMovie(Long id, MovieRequestDto dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND + id));
        movieMapper.updateMovieFromDto(dto, movie);
        enrichMovieWithDateData(movie);
        movieRepository.save(movie);
        movieActorService.updateCast(movie.getId(), dto.actorIds());
        return movieMapper.toResponseDto(movie);
    }

    @Override
    @Transactional
    public void softDeleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new EntityNotFoundException(MOVIE_NOT_FOUND + id);
        }
        movieRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovieShortResponseDto> getAllShort(Pageable pageable) {
        return movieRepository.findAllByOrderByAverageRatingDesc(pageable)
                .map(movieMapper::toShortDto);
    }

    @Override
    @Transactional(readOnly = true)
    public MovieFullResponseDto getFullById(Long id) {
        Movie movie = movieRepository.findByIdWithAll(id)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND + id));
        Set<String> directors = directorRepository.findAllByMovies_Id(id).stream()
                .map(Director::getFullName)
                .collect(Collectors.toSet());
        return movieMapper.toFullDto(movie, directors);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovieShortResponseDto> search(MovieSearchParametersDto params, Pageable pageable) {
        Specification<Movie> spec = movieSpecificationBuilder.build(params);
        return movieRepository.findAll(spec, pageable)
                .map(movieMapper::toShortDto);
    }

    @Override
    @Transactional(readOnly = true)
    public MovieFiltersResponseDto getFilters() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Enum::name)
                .toList();

        List<String> ageRating = Arrays.stream(AgeRating.values())
                .map(Enum::name)
                .toList();

        List<String> genres = genreRepository.findAll()
                .stream()
                .map(Genre::getName)
                .toList();

        int currentYear = Year.now().getValue();
        List<Integer> years = IntStream.rangeClosed(1900, currentYear)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();

        List<Double> ratingValues = IntStream.rangeClosed(1, 10)
                .mapToDouble(i -> i)
                .boxed()
                .toList();

        return new MovieFiltersResponseDto(categories, genres, ageRating, years, ratingValues);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovieShortResponseDto> getTopByCurrentSeason(Pageable pageable) {
        Season currentSeason = determineSeasonFromDate(LocalDate.now());
        return movieRepository.findAllBySeasonOrderByAverageRatingDesc(currentSeason, pageable)
                .map(movieMapper::toShortDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovieShortResponseDto> getSimilarMovies(Long movieId) {
        Movie movie = movieRepository.findByIdWithAll(movieId)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND + movieId));

        Set<Long> genreIds = movie.getGenres().stream()
                .map(Genre::getId)
                .collect(Collectors.toSet());

        if (genreIds.isEmpty()) {
            return List.of();
        }

        return movieRepository.findAll().stream()
                .filter(m -> !m.getId().equals(movieId))
                .filter(m -> m.getGenres().stream().anyMatch(g -> genreIds.contains(g.getId())))
                .sorted(Comparator.comparing(
                        (Movie m) -> Optional.ofNullable(m.getAverageRating())
                                .orElse(BigDecimal.ZERO))
                        .reversed())
                .limit(10)
                .map(movieMapper::toShortDto)
                .toList();
    }

    private void enrichMovieWithDateData(Movie movie) {
        if (movie.getReleaseDate() != null) {
            movie.setYear(movie.getReleaseDate().getYear());
            movie.setSeason(determineSeasonFromDate(movie.getReleaseDate()));
        }
    }

    private Season determineSeasonFromDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return switch (date.getMonthValue()) {
            case 12, 1, 2 -> Season.WINTER;
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            default -> Season.AUTUMN;
        };
    }
}
