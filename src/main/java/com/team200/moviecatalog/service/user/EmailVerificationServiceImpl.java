package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.exception.RegistrationException;
import com.team200.moviecatalog.model.EmailVerificationToken;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.user.EmailVerificationTokenRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private static final String INVALID_TOKEN = "Invalid token";
    private static final String TOKEN_EXPIRED = "Token expired";
    private static final String EMAIL_VERIFIED_MESSAGE = "Email verified!";
    private static final String EMAIL_ALREADY_VERIFIED = "Email already verified";
    private static final String VERIFICATION_SENT = "Verification email sent";
    private static final String USER_NOT_FOUND = "User not found: ";

    private final EmailVerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Override
    public String verify(String token) {
        return EMAIL_VERIFIED_MESSAGE;
    }

    @Override
    public String resend(String email) {
        return "Verification disabled";
    }
}
