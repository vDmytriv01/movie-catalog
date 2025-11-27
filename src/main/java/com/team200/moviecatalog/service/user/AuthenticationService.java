package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.constants.ErrorMessages;
import com.team200.moviecatalog.dto.user.UserLoginRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginResponseDto;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String INVALID_CREDENTIALS = ErrorMessages.INVALID_EMAIL_OR_PASSWORD;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public UserLoginResponseDto authenticate(UserLoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new BadCredentialsException(INVALID_CREDENTIALS));

        if (!user.isEmailVerified()) {
            throw new BadCredentialsException(INVALID_CREDENTIALS);
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));

            String token = jwtUtil.generateToken(authentication.getName());
            return new UserLoginResponseDto(token);
        } catch (AuthenticationException ex) {
            throw new BadCredentialsException(INVALID_CREDENTIALS, ex);
        }
    }
}
