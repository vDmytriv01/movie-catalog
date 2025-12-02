package com.team200.moviecatalog.mapper;

import com.team200.moviecatalog.dto.feedback.FeedbackResponseDto;
import com.team200.moviecatalog.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    @Mapping(target = "reviewId", source = "review.id")
    @Mapping(target = "movieId", source = "review.movie.id")
    @Mapping(target = "nickname", source = "review.user.nickname")
    @Mapping(target = "createdAt", source = "review.createdAt")
    @Mapping(target = "comment", source = "review.comment")
    @Mapping(target = "rating", source = "rating")
    FeedbackResponseDto toDto(Review review, Integer rating);
}
