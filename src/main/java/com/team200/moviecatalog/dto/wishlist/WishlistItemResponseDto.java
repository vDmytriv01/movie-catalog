package com.team200.moviecatalog.dto.wishlist;

import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;

public record WishlistItemResponseDto(
        Long itemId,
        MovieShortResponseDto movie
) {}
