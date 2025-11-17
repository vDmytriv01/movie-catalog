package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;
import com.team200.moviecatalog.mapper.WishlistMapper;
import com.team200.moviecatalog.service.wishlist.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;
    private final WishlistMapper wishlistMapper;

    @PostMapping("/{movieId}")
    public String toggle(
            @PathVariable Long movieId,
            @AuthenticationPrincipal UserDetails user
    ) {
        return wishlistService.toggleWithUser(user, movieId);
    }

    @GetMapping
    public WishlistResponseDto get(
            @AuthenticationPrincipal UserDetails user
    ) {
        return wishlistMapper.toDto(wishlistService.getWithUser(user));
    }
}
