package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto registration(UserRegisterRequestDto requestDto);

    UserResponseDto getCurrentUser(String email);

    UserResponseDto updateUser(String email, UserResponseDto updateDto);

    void deleteUser(String email);
}
