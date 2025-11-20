package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.comment.ReviewCommentRequestDto;
import com.team200.moviecatalog.dto.comment.ReviewCommentResponseDto;
import com.team200.moviecatalog.service.comment.ReviewCommentService;
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
@RequestMapping("/reviews/{reviewId}/comments")
@RequiredArgsConstructor
public class ReviewCommentController {

    private final ReviewCommentService commentService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewCommentResponseDto addComment(
            @PathVariable Long reviewId,
            @Valid @RequestBody ReviewCommentRequestDto dto,
            @AuthenticationPrincipal UserDetails user
    ) {
        return commentService.addComment(reviewId, dto, user);
    }

    @GetMapping
    public List<ReviewCommentResponseDto> getCommentsByReview(
            @PathVariable Long reviewId
    ) {
        return commentService.getCommentsByReview(reviewId);
    }
}
