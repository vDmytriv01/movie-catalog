package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.user.UserLoginRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginResponseDto;
import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import com.team200.moviecatalog.service.user.AuthenticationService;
import com.team200.moviecatalog.service.user.EmailVerificationService;
import com.team200.moviecatalog.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final EmailVerificationService emailVerificationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@Valid @RequestBody UserRegisterRequestDto dto) {
        return userService.registration(dto);
    }

    @GetMapping("/verify-email")
    public String verifyEmail(@RequestParam String token) {
        return emailVerificationService.verify(token);
    }

    @PostMapping("/resend-verification")
    public String resendVerification(@RequestParam String email) {
        return emailVerificationService.resend(email);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid @RequestBody UserLoginRequestDto dto) {
        return authenticationService.authenticate(dto);
    }
}
