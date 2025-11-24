package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.dto.user.UserLoginRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginResponseDto;
import com.team200.moviecatalog.exception.RegistrationException;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String INVALID_CREDENTIALS = "Invalid email or password";
    private static final String EMAIL_NOT_VERIFIED = "Email is not verified";

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public UserLoginResponseDto authenticate(UserLoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RegistrationException(INVALID_CREDENTIALS));

        if (!user.isEmailVerified()) {
            throw new RegistrationException(EMAIL_NOT_VERIFIED);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));

        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }
}
