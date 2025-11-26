package com.team200.moviecatalog.service.user;

public interface EmailService {
    void sendVerificationEmail(String to, String token);

    void sendPasswordResetEmail(String to, String resetLink);
}
