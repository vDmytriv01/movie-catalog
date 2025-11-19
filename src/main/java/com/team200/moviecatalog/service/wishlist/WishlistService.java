package com.team200.moviecatalog.service.wishlist;

import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;

public interface WishlistService {

    WishlistResponseDto getForUser(String email);

    WishlistResponseDto add(String email, Long movieId);

    void remove(String email, Long movieId);
}
