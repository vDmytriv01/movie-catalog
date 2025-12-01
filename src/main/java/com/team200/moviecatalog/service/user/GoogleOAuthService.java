package com.team200.moviecatalog.service.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.team200.moviecatalog.constants.ErrorMessages;
import com.team200.moviecatalog.dto.user.GoogleOAuthUserDto;
import java.io.IOException;
import java.security.GeneralSecurityException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class GoogleOAuthService {

    private final GoogleIdTokenVerifier googleIdTokenVerifier;

    public GoogleOAuthUserDto verify(String idToken) {
        try {
            GoogleIdToken token = googleIdTokenVerifier.verify(idToken);

            if (token == null) {
                throw new BadCredentialsException(ErrorMessages.GOOGLE_INVALID_ID_TOKEN);
            }

            Payload payload = token.getPayload();
            String email = payload.getEmail();
            boolean emailVerified = Boolean.TRUE.equals(payload.getEmailVerified());

            if (!emailVerified || !StringUtils.hasText(email)) {
                throw new BadCredentialsException(ErrorMessages.GOOGLE_INVALID_ID_TOKEN);
            }

            String name = (String) payload.get("name");
            String picture = (String) payload.get("picture");

            return new GoogleOAuthUserDto(email, name, picture);
        } catch (GeneralSecurityException | IOException e) {
            throw new BadCredentialsException(ErrorMessages.GOOGLE_TOKEN_VERIFICATION_FAILED, e);
        }
    }
}
