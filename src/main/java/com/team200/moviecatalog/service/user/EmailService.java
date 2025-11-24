package com.team200.moviecatalog.service.user;

public interface EmailService {
    void sendVerificationEmail(String to, String token);
}
