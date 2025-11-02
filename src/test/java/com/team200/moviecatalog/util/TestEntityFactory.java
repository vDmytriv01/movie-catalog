package com.team200.moviecatalog.util;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.Rating;
import com.team200.moviecatalog.model.Review;
import com.team200.moviecatalog.model.User;

public final class TestEntityFactory {

    private TestEntityFactory() {
    }

    public static Movie movieWithId(Long id) {
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }

    public static User userWithId(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    public static Rating rating(Long id, int value, Movie movie, User user) {
        Rating rating = new Rating();
        rating.setId(id);
        rating.setValue(value);
        rating.setMovie(movie);
        rating.setUser(user);
        return rating;
    }

    public static Review review(Long id, String comment, Movie movie, User user) {
        Review review = new Review();
        review.setId(id);
        review.setComment(comment);
        review.setMovie(movie);
        review.setUser(user);
        return review;
    }
}
