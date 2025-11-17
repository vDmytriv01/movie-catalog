package com.team200.moviecatalog.service.wishlist;

import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.model.WishlistItem;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistItemRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final WishlistItemRepository itemRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public String toggleWithUser(UserDetails userDetails, Long movieId) {
        String email = userDetails.getUsername();
        return toggleByEmail(email, movieId) ? "ADDED" : "REMOVED";
    }

    public Wishlist getWithUser(UserDetails userDetails) {
        String email = userDetails.getUsername();
        return getByEmail(email);
    }

    public Wishlist create(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        Wishlist wishlist = Wishlist.builder()
                .user(user)
                .items(new ArrayList<>())
                .build();

        return wishlistRepository.save(wishlist);
    }

    public Wishlist getByEmail(String email) {
        return wishlistRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));
    }

    public boolean toggleByEmail(String email, Long movieId) {
        Wishlist wishlist = getByEmail(email);

        var existing = itemRepository.findByWishlistIdAndMovieId(wishlist.getId(), movieId);
        if (existing.isPresent()) {
            itemRepository.delete(existing.get());
            return false;
        }

        Movie movie = movieRepository.findById(movieId).orElseThrow();

        WishlistItem item = WishlistItem.builder()
                .wishlist(wishlist)
                .movie(movie)
                .build();

        itemRepository.save(item);
        return true;
    }
}
