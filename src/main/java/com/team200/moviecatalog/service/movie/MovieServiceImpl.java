package com.team200.moviecatalog.service.movie;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieRequestDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.mapper.MovieMapper;
import com.team200.moviecatalog.mapper.RatingMapper;
import com.team200.moviecatalog.mapper.ReviewMapper;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Season;
import com.team200.moviecatalog.repository.genre.GenreRepository;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.movie.MovieSpecificationBuilder;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
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

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final RatingRepository ratingRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;
    private final RatingMapper ratingMapper;
    private final MovieSpecificationBuilder movieSpecificationBuilder;

    @Override
    @Transactional
    public MovieFullResponseDto createMovie(MovieRequestDto dto) {
        Movie movie = movieMapper.toEntity(dto);
        enrichMovieWithDateData(movie);
        movieRepository.save(movie);
        return movieMapper.toFullDto(movie);
    }

    @Override
    @Transactional
    public MovieFullResponseDto updateMovie(Long id, MovieRequestDto dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));
        movieMapper.updateMovieFromDto(dto, movie);
        enrichMovieWithDateData(movie);
        movieRepository.save(movie);
        return movieMapper.toFullDto(movie);
    }

    @Override
    @Transactional
    public void softDeleteMovie(Long id) {
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
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));

        var reviews = reviewRepository.findAllByMovieId(id)
                .stream()
                .map(reviewMapper::toDto)
                .toList();

        var ratings = ratingRepository.findAllByMovieId(id)
                .stream()
                .map(ratingMapper::toDto)
                .toList();

        var base = movieMapper.toFullDto(movie);
        return new MovieFullResponseDto(
                base.id(), base.title(), base.description(), base.releaseDate(), base.year(),
                base.duration(), base.averageRating(), base.posterUrl(), base.trailerUrl(),
                base.directors(), base.genres(), base.actors(), base.countries(),
                base.ageRating(), base.category(),
                reviews, ratings
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovieShortResponseDto> search(MovieSearchParametersDto params, Pageable pageable) {
        Specification<Movie> spec = movieSpecificationBuilder.build(params);
        return movieRepository.findAll(spec, pageable)
                .map(movieMapper::toShortDto);
    }

    @Override
    public MovieFiltersResponseDto getFilters() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Enum::name)
                .toList();

        List<String> ageRatings = Arrays.stream(AgeRating.values())
                .map(ar -> ar.getValue() + "+")
                .toList();

        List<String> genres = genreRepository.findAll()
                .stream()
                .map(g -> g.getName())
                .toList();

        int currentYear = Year.now().getValue();
        List<Integer> years = IntStream.rangeClosed(1900, currentYear)
                .boxed()
                .sorted((a, b) -> b - a)
                .toList();

        List<Double> ratingValues = IntStream.rangeClosed(1, 10)
                .mapToDouble(i -> i)
                .boxed()
                .toList();

        return new MovieFiltersResponseDto(categories, genres, ageRatings, years, ratingValues);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovieShortResponseDto> getTopByCurrentSeason(Pageable pageable) {
        Season currentSeason = determineSeasonFromDate(LocalDate.now());
        return movieRepository.findAllBySeasonOrderByAverageRatingDesc(currentSeason, pageable)
                .map(movieMapper::toShortDto);
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
        int month = date.getMonthValue();
        return switch (month) {
            case 12, 1, 2 -> Season.WINTER;
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            default -> Season.AUTUMN;
        };
    }
}
