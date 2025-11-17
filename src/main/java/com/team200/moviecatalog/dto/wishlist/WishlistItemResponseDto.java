package com.team200.moviecatalog.dto.wishlist;

import lombok.Data;

@Data
public class WishlistItemResponseDto {
    private Long itemId;
    private Long movieId;
    private String movieTitle;
}
