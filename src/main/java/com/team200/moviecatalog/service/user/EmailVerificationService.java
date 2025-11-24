package com.team200.moviecatalog.service.user;

public interface EmailVerificationService {
    String verify(String token);

    String resend(String email);
}
