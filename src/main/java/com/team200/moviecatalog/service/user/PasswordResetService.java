package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.exception.RegistrationException;
import com.team200.moviecatalog.model.PasswordResetToken;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.user.PasswordResetTokenRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private static final String INVALID_TOKEN_ERROR =
            "Invalid or expired password reset token";

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Value("${app.password-reset.token-expiration-minutes}")
    private long tokenExpirationMinutes;

    @Value("${app.password-reset.base-url}")
    private String resetPasswordBaseUrl;

    @Transactional
    public void requestPasswordReset(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            String token = UUID.randomUUID().toString();

            PasswordResetToken resetToken = new PasswordResetToken();
            resetToken.setToken(token);
            resetToken.setUser(user);
            resetToken.setExpiresAt(LocalDateTime.now().plusMinutes(tokenExpirationMinutes));
            resetToken.setUsed(false);

            passwordResetTokenRepository.save(resetToken);

            String resetLink = resetPasswordBaseUrl + "?token=" + token;
            emailService.sendPasswordResetEmail(user.getEmail(), resetLink);
        });
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
                .orElseThrow(() -> new RegistrationException(INVALID_TOKEN_ERROR));

        if (resetToken.isUsed() || resetToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RegistrationException(INVALID_TOKEN_ERROR);
        }

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        resetToken.setUsed(true);
        passwordResetTokenRepository.save(resetToken);
    }
}
