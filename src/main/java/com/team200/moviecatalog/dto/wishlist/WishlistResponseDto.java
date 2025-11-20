package com.team200.moviecatalog.dto.wishlist;

import java.util.List;

public record WishlistResponseDto(
        Long wishlistId,
        Long userId,
        List<WishlistItemResponseDto> items) {

}
