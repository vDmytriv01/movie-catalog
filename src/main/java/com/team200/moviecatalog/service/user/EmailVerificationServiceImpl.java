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
        EmailVerificationToken verificationToken =
                tokenRepository.findByToken(token)
                        .orElseThrow(() -> new RegistrationException(INVALID_TOKEN));

        if (verificationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RegistrationException(TOKEN_EXPIRED);
        }

        User user = verificationToken.getUser();
        user.setEmailVerified(true);
        userRepository.save(user);

        tokenRepository.delete(verificationToken);

        return EMAIL_VERIFIED_MESSAGE;
    }

    @Override
    public String resend(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RegistrationException(USER_NOT_FOUND + email));

        if (user.isEmailVerified()) {
            throw new RegistrationException(EMAIL_ALREADY_VERIFIED);
        }

        tokenRepository.findByUser(user)
                .ifPresent(tokenRepository::delete);

        EmailVerificationToken newToken = new EmailVerificationToken();
        newToken.setToken(UUID.randomUUID().toString());
        newToken.setExpiresAt(LocalDateTime.now().plusHours(24));
        newToken.setUser(user);

        tokenRepository.save(newToken);

        emailService.sendVerificationEmail(user.getEmail(), newToken.getToken());

        return VERIFICATION_SENT;
    }
}
