package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.config.CentralMapperConfig;
import com.team200.moviecatalog.dto.comment.ReviewCommentRequestDto;
import com.team200.moviecatalog.dto.comment.ReviewCommentResponseDto;
import com.team200.moviecatalog.model.ReviewComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CentralMapperConfig.class)
public interface ReviewCommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "review", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "parentComment", source = "parentCommentId",
            qualifiedByName = "commentFromId")
    ReviewComment toEntity(ReviewCommentRequestDto dto);

    @Mapping(target = "userNickname", source = "user.nickname")
    @Mapping(target = "parentCommentId", source = "parentComment.id")
    ReviewCommentResponseDto toDto(ReviewComment comment);

    @Named("commentFromId")
    default ReviewComment commentFromId(Long id) {
        if (id == null) {
            return null;
        }
        ReviewComment c = new ReviewComment();
        c.setId(id);
        return c;
    }
}
