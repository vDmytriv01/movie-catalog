package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.dto.wishlist.WishlistItemResponseDto;
import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.model.WishlistItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WishlistMapper {

    @Mapping(target = "itemId", source = "id")
    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "movieTitle", source = "movie.title")
    WishlistItemResponseDto toDto(WishlistItem item);

    @Mapping(target = "wishlistId", source = "id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "items", expression = "java("
            + "wishlist.getItems().stream().map(this::toDto).toList()"
            + ")")
    WishlistResponseDto toDto(Wishlist wishlist);
}
