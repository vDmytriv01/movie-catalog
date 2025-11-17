package com.team200.moviecatalog.dto.wishlist;

import java.util.List;
import lombok.Data;

@Data
public class WishlistResponseDto {
    private Long wishlistId;
    private Long userId;
    private List<WishlistItemResponseDto> items;
}
