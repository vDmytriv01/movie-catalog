package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;
import com.team200.moviecatalog.service.wishlist.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @GetMapping
    public WishlistResponseDto getWishlist(@AuthenticationPrincipal UserDetails user) {
        return wishlistService.getForUser(user.getUsername());
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/items/{movieId}")
    @ResponseStatus(HttpStatus.CREATED)
    public WishlistResponseDto addItem(
            @PathVariable Long movieId,
            @AuthenticationPrincipal UserDetails user
    ) {
        return wishlistService.add(user.getUsername(), movieId);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/items/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(
            @PathVariable Long movieId,
            @AuthenticationPrincipal UserDetails user
    ) {
        wishlistService.remove(user.getUsername(), movieId);
    }
}
