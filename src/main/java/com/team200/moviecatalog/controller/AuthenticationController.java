package com.team200.moviecatalog.controller;

import com.team200.moviecatalog.dto.response.ApiMessageResponse;
import com.team200.moviecatalog.dto.user.PasswordResetConfirmDto;
import com.team200.moviecatalog.dto.user.PasswordResetRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginResponseDto;
import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import com.team200.moviecatalog.service.user.AuthenticationService;
import com.team200.moviecatalog.service.user.EmailVerificationService;
import com.team200.moviecatalog.service.user.PasswordResetService;
import com.team200.moviecatalog.service.user.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final EmailVerificationService emailVerificationService;
    private final PasswordResetService passwordResetService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@Valid @RequestBody UserRegisterRequestDto dto) {
        return userService.registration(dto);
    }

    @GetMapping("/verify-email")
    public ResponseEntity<ApiMessageResponse> verifyEmail(
            @RequestParam @NotBlank String token) {
        return ResponseEntity.ok(
                new ApiMessageResponse(emailVerificationService.verify(token))
        );
    }

    @PostMapping("/resend-verification")
    public ResponseEntity<ApiMessageResponse> resendVerification(
            @RequestParam @Email @NotBlank String email) {
        return ResponseEntity.ok(
                new ApiMessageResponse(emailVerificationService.resend(email))
        );
    }

    @PostMapping("/password/reset-request")
    @ResponseStatus(HttpStatus.OK)
    public void requestPasswordReset(@RequestBody @Valid PasswordResetRequestDto dto) {
        passwordResetService.requestPasswordReset(dto.email());
    }

    @PostMapping("/password/reset")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiMessageResponse> resetPassword(
            @RequestBody @Valid PasswordResetConfirmDto dto) {
        passwordResetService.resetPassword(dto.token(), dto.newPassword());
        return ResponseEntity.ok(new ApiMessageResponse("Password successfully reset."));
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid @RequestBody UserLoginRequestDto dto) {
        return authenticationService.authenticate(dto);
    }
}
