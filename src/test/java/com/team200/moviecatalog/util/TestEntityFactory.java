package com.team200.moviecatalog.util;

import com.team200.moviecatalog.model.Actor;
import com.team200.moviecatalog.model.Country;
import com.team200.moviecatalog.model.Director;
import com.team200.moviecatalog.model.Genre;
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

    public static Director director(Long id, String fullName) {
        Director d = new Director();
        d.setId(id);
        d.setFullName(fullName);
        return d;
    }

    public static Actor actor(Long id, String fullName) {
        Actor a = new Actor();
        a.setId(id);
        a.setFullName(fullName);
        return a;
    }

    public static Genre genre(Long id, String name) {
        Genre g = new Genre();
        g.setId(id);
        g.setName(name);
        return g;
    }

    public static Country country(Long id, String name) {
        Country c = new Country();
        c.setId(id);
        c.setName(name);
        return c;
    }
}
