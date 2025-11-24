package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.dto.user.UpdateAvatarResponseDto;
import com.team200.moviecatalog.dto.user.UpdateUserRequestDto;
import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import com.team200.moviecatalog.exception.ConflictException;
import com.team200.moviecatalog.exception.EntityNotFoundException;
import com.team200.moviecatalog.exception.RegistrationException;
import com.team200.moviecatalog.mapper.UserMapper;
import com.team200.moviecatalog.model.EmailVerificationToken;
import com.team200.moviecatalog.model.Role;
import com.team200.moviecatalog.model.RoleName;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.model.Wishlist;
import com.team200.moviecatalog.repository.role.RoleRepository;
import com.team200.moviecatalog.repository.user.EmailVerificationTokenRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import com.team200.moviecatalog.repository.wishlist.WishlistRepository;
import com.team200.moviecatalog.service.uploads.FileStorageService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not found: ";
    private static final String EMAIL_EXISTS = "Email already exists: ";
    private static final String NICKNAME_EXISTS = "Nickname already taken: ";
    private static final String PASSWORDS_NOT_MATCH = "Passwords do not match";
    private static final String ROLE_NOT_FOUND = "Role USER not found ";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final WishlistRepository wishlistRepository;
    private final EmailVerificationTokenRepository emailVerificationTokenRepository;
    private final EmailService emailService;
    private final FileStorageService fileStorageService;

    @Override
    public UserResponseDto registration(UserRegisterRequestDto requestDto) {

        if (userRepository.existsByEmail(requestDto.email())) {
            throw new ConflictException(EMAIL_EXISTS + requestDto.email());
        }

        if (userRepository.existsByNickname(requestDto.nickname())) {
            throw new ConflictException(NICKNAME_EXISTS + requestDto.nickname());
        }

        if (!requestDto.password().equals(requestDto.repeatPassword())) {
            throw new RegistrationException(PASSWORDS_NOT_MATCH);
        }

        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new EntityNotFoundException(ROLE_NOT_FOUND));

        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.password()));
        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);

        Wishlist wishlist = Wishlist.builder()
                .user(savedUser)
                .build();
        wishlistRepository.save(wishlist);

        EmailVerificationToken token = new EmailVerificationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setExpiresAt(LocalDateTime.now().plusHours(24));
        token.setUser(savedUser);
        emailVerificationTokenRepository.save(token);

        emailService.sendVerificationEmail(savedUser.getEmail(), token.getToken());

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + email));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(String email, UpdateUserRequestDto updateDto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + email));

        if (updateDto.nickname() != null
                && !updateDto.nickname().equals(user.getNickname())) {

            if (userRepository.existsByNickname(updateDto.nickname())) {
                throw new ConflictException(NICKNAME_EXISTS + updateDto.nickname());
            }
            user.setNickname(updateDto.nickname());
        }

        if (updateDto.profileUrl() != null) {
            user.setProfileImageUrl(updateDto.profileUrl());
        }

        User updated = userRepository.save(user);
        return userMapper.toDto(updated);
    }

    @Override
    public UpdateAvatarResponseDto updateAvatar(String email, MultipartFile file) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + email));

        String url = fileStorageService.saveUserAvatar(user.getId(), file);

        user.setProfileImageUrl(url);
        userRepository.save(user);

        return new UpdateAvatarResponseDto(url);
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + email));
        emailVerificationTokenRepository.findByUser(user)
                .ifPresent(emailVerificationTokenRepository::delete);
        userRepository.delete(user);
    }
}
