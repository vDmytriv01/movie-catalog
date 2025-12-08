package com.team200.moviecatalog.repository.comment;

import com.team200.moviecatalog.model.ReviewComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {

    List<ReviewComment> findByReviewId(Long reviewId);
}
