package com.team200.moviecatalog.repository.wishlist;

import com.team200.moviecatalog.model.Wishlist;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @EntityGraph(attributePaths = {"items", "items.movie"})
    Optional<Wishlist> findByUserEmail(String email);
}
