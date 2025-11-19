package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.wishlist.WishlistItemResponseDto;
import com.team200.moviecatalog.dto.wishlist.WishlistResponseDto;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.model.WishlistItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CentralMapperConfig.class,
        uses = {MovieMapper.class})
public interface WishlistMapper {

    @Mapping(source = "id", target = "itemId")
    @Mapping(source = "movie", target = "movie")
    WishlistItemResponseDto toItemDto(WishlistItem item);

    @Mapping(source = "id", target = "wishlistId")
    @Mapping(source = "user.id", target = "userId")
    WishlistResponseDto toDto(Wishlist wishlist);
}
