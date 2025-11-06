package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import com.team200.moviecatalog.exception.RegistrationException;
import com.team200.moviecatalog.mapper.UserMapper;
import com.team200.moviecatalog.model.Role;
import com.team200.moviecatalog.model.RoleName;
import com.team200.moviecatalog.model.User;
import com.team200.moviecatalog.repository.role.RoleRepository;
import com.team200.moviecatalog.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto registration(UserRegisterRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.email())) {
            throw new RegistrationException("User already exists with email "
                    + requestDto.email());
        }

        if (userRepository.existsByNickname(requestDto.nickname())) {
            throw new RegistrationException("User already exists with nickname "
                    + requestDto.nickname());
        }

        if (!requestDto.password().equals(requestDto.repeatPassword())) {
            throw new RegistrationException("Passwords do not match");
        }

        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new RegistrationException("Default role USER not found"));

        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.password()));
        user.setRoles(Set.of(userRole));

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RegistrationException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(String email, UserResponseDto updateDto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RegistrationException("User not found"));

        if (updateDto.firstName() != null) {
            user.setFirstName(updateDto.firstName());
        }
        if (updateDto.lastName() != null) {
            user.setLastName(updateDto.lastName());
        }
        if (updateDto.profileImageUrl() != null) {
            user.setProfileImageUrl(updateDto.profileImageUrl());
        }
        if (updateDto.nickname() != null
                && !updateDto.nickname().equals(user.getNickname())) {
            if (userRepository.existsByNickname(updateDto.nickname())) {
                throw new RegistrationException("Nickname already taken");
            }
            user.setNickname(updateDto.nickname());
        }

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RegistrationException("User not found"));
        userRepository.delete(user);
    }
}
