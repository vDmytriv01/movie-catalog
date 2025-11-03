package com.team200.moviecatalog.service;

import com.team200.moviecatalog.dto.movie.MovieFiltersResponseDto;
import com.team200.moviecatalog.dto.movie.MovieFullResponseDto;
import com.team200.moviecatalog.dto.movie.MovieSearchParametersDto;
import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import com.team200.moviecatalog.mapper.MovieMapper;
import com.team200.moviecatalog.mapper.RatingMapper;
import com.team200.moviecatalog.mapper.ReviewMapper;
import com.team200.moviecatalog.model.AgeRating;
import com.team200.moviecatalog.model.Category;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.repository.genre.GenreRepository;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.movie.MovieSpecificationBuilder;
import com.team200.moviecatalog.repository.rating.RatingRepository;
import com.team200.moviecatalog.repository.review.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
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
    @Transactional(readOnly = true)
    public List<MovieShortResponseDto> getAllShort() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toShortDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MovieFullResponseDto getFullById(Long id) {
        Movie movie = movieRepository.findByIdWithAll(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));

        var reviews = reviewRepository.findAllByMovieId(id).stream()
                .map(reviewMapper::toDto)
                .toList();

        var ratings = ratingRepository.findAllByMovieId(id).stream()
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
    public List<MovieShortResponseDto> search(MovieSearchParametersDto params) {
        Specification<Movie> spec = movieSpecificationBuilder.build(params);

        return movieRepository.findAll(spec).stream()
                .map(movieMapper::toShortDto)
                .toList();
    }

    @Override
    public MovieFiltersResponseDto getFilters() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Enum::name)
                .toList();

        List<String> ageRatings = Arrays.stream(AgeRating.values())
                .map(Enum::name)
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

        List<Integer> ratings = IntStream.rangeClosed(1, 10).boxed().toList();

        return new MovieFiltersResponseDto(categories, genres, ageRatings, years, ratings);
    }
}
