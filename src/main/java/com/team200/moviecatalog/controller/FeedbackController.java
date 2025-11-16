package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.feedback.FeedbackRequestDto;
import com.team200.moviecatalog.dto.feedback.FeedbackResponseDto;
import com.team200.moviecatalog.service.feedback.FeedbackService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies/{movieId}/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FeedbackResponseDto> getFeedbackByMovie(@PathVariable Long movieId) {
        return feedbackService.getFeedbackByMovie(movieId);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackResponseDto addOrUpdateFeedback(
            @PathVariable Long movieId,
            @Valid @RequestBody FeedbackRequestDto dto,
            @AuthenticationPrincipal UserDetails user
    ) {
        return feedbackService.createFeedback(movieId, dto, user);
    }
}
