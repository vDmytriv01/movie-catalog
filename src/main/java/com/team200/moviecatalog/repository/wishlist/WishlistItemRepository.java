package com.team200.moviecatalog.repository.wishlist;

import com.team200.moviecatalog.model.WishlistItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    Optional<WishlistItem> findByWishlistIdAndMovieId(Long wishlistId, Long movieId);
}
