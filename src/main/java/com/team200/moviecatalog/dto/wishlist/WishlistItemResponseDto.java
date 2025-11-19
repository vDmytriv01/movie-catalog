package com.team200.moviecatalog.dto.wishlist;

import com.team200.moviecatalog.dto.movie.MovieShortResponseDto;
import lombok.Data;

@Data
public class WishlistItemResponseDto {
    private Long itemId;
    private MovieShortResponseDto movie;
}
