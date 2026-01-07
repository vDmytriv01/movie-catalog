package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.user.ChangePasswordRequestDto;
import com.team200.moviecatalog.dto.user.UpdateAvatarResponseDto;
import com.team200.moviecatalog.dto.user.UpdateUserRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import com.team200.moviecatalog.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/current")
    public UserResponseDto getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getCurrentUser(userDetails.getUsername());
    }

    @PutMapping("/current")
    public UserResponseDto updateUser(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody UpdateUserRequestDto updateDto
    ) {
        return userService.updateUser(userDetails.getUsername(), updateDto);
    }

    @PostMapping("/current/avatar")
    public UpdateAvatarResponseDto uploadAvatar(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("file") MultipartFile file
    ) {
        return userService.updateAvatar(userDetails.getUsername(), file);
    }

    @PutMapping("/current/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody ChangePasswordRequestDto dto
    ) {
        userService.changePassword(userDetails.getUsername(), dto);
    }

    @DeleteMapping("/current")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteUser(userDetails.getUsername());
    }
}
