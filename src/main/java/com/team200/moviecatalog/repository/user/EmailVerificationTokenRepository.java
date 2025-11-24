package com.team200.moviecatalog.repository.user;

import com.team200.moviecatalog.model.EmailVerificationToken;
import com.team200.moviecatalog.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationTokenRepository
        extends JpaRepository<EmailVerificationToken, Long> {

    Optional<EmailVerificationToken> findByToken(String token);

    Optional<EmailVerificationToken> findByUser(User user);
}
