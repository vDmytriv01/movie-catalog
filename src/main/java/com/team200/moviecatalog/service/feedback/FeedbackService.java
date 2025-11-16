package com.team200.moviecatalog.service.feedback;

import com.team200.moviecatalog.dto.feedback.FeedbackRequestDto;
import com.team200.moviecatalog.dto.feedback.FeedbackResponseDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

public interface FeedbackService {
    List<FeedbackResponseDto> getFeedbackByMovie(Long movieId);

    FeedbackResponseDto createFeedback(Long movieId, FeedbackRequestDto dto, UserDetails user);
}
