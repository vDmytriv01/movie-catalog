package com.team200.moviecatalog.repository.review.projection;

import java.time.LocalDateTime;

public interface FeedbackProjection {
    Long getReviewId();

    Long getMovieId();

    Integer getRating();

    String getComment();

    String getNickname();

    LocalDateTime getCreatedAt();
}
