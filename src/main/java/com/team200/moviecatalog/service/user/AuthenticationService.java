package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.constants.ErrorMessages;
import com.team200.moviecatalog.dto.user.GoogleOAuthUserDto;
import com.team200.moviecatalog.dto.user.UserLoginRequestDto;
import com.team200.moviecatalog.dto.user.UserLoginResponseDto;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.model.Role;
import com.team200.moviecatalog.model.RoleName;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.repository.role.RoleRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistRepository;
import com.team200.moviecatalog.security.JwtUtil;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static final String INVALID_CREDENTIALS = ErrorMessages.INVALID_EMAIL_OR_PASSWORD;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final WishlistRepository wishlistRepository;
    private final PasswordEncoder passwordEncoder;
    private final GoogleOAuthService googleOAuthService;

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

    public UserLoginResponseDto authenticateWithGoogle(String idToken) {
        GoogleOAuthUserDto googleUser = googleOAuthService.verify(idToken);

        User user = userRepository.findByEmail(googleUser.email())
                .map(this::verifyExistingUser)
                .orElseGet(() -> createUserFromGoogle(googleUser));

        String token = jwtUtil.generateToken(user.getEmail());
        return new UserLoginResponseDto(token);
    }

    private User verifyExistingUser(User user) {
        if (!user.isEmailVerified()) {
            user.setEmailVerified(true);
            userRepository.save(user);
        }
        return user;
    }

    private User createUserFromGoogle(GoogleOAuthUserDto googleUser) {
        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessages.ROLE_USER_NOT_FOUND));

        User user = new User();
        user.setEmail(googleUser.email());
        user.setNickname(generateUniqueNickname(googleUser));
        user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
        user.setProfileImageUrl(googleUser.pictureUrl());
        user.setEmailVerified(true);
        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);

        Wishlist wishlist = Wishlist.builder()
                .user(savedUser)
                .build();
        wishlistRepository.save(wishlist);

        return savedUser;
    }

    private String generateUniqueNickname(GoogleOAuthUserDto googleUser) {
        String baseName = StringUtils.hasText(googleUser.nickname())
                ? googleUser.nickname().replaceAll("\\s+", "")
                : googleUser.email().split("@")[0];

        String normalized = baseName.replaceAll("[^A-Za-z0-9]", "");
        if (!StringUtils.hasText(normalized)) {
            normalized = "user";
        }

        String candidate = normalized;
        int suffix = 1;

        while (userRepository.existsByNickname(candidate)) {
            candidate = normalized + suffix++;
        }

        return candidate;
    }

}
