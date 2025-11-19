package com.team200.moviecatalog.service.wishlist;

import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;
import com.team200.moviecatalog.mapper.WishlistMapper;
import com.team200.moviecatalog.model.Movie;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.model.WishlistItem;
import com.team200.moviecatalog.repository.movie.MovieRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistItemRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final WishlistItemRepository itemRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final WishlistMapper wishlistMapper;

    @Override
    @Transactional(readOnly = true)
    public WishlistResponseDto getForUser(String email) {
        Wishlist wishlist = wishlistRepository.findByUserEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));

        return wishlistMapper.toDto(wishlist);
    }

    @Override
    @Transactional
    public WishlistResponseDto add(String email, Long movieId) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Wishlist wishlist = wishlistRepository.findByUserEmail(email)
                .orElseGet(() -> createWishlist(user));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        itemRepository.findByWishlistIdAndMovieId(wishlist.getId(), movieId)
                .ifPresent(item -> {
                    throw new IllegalStateException("Movie already in wishlist");
                });

        WishlistItem item = WishlistItem.builder()
                .wishlist(wishlist)
                .movie(movie)
                .build();

        wishlist.getItems().add(item);
        wishlistRepository.save(wishlist);

        return wishlistMapper.toDto(wishlist);
    }

    @Override
    @Transactional
    public void remove(String email, Long movieId) {

        Wishlist wishlist = wishlistRepository.findByUserEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));

        WishlistItem item = itemRepository.findByWishlistIdAndMovieId(wishlist.getId(), movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not in wishlist"));

        wishlist.getItems().remove(item);
        itemRepository.delete(item);
    }

    private Wishlist createWishlist(User user) {
        Wishlist wishlist = Wishlist.builder()
                .user(user)
                .build();
        return wishlistRepository.save(wishlist);
    }
}
