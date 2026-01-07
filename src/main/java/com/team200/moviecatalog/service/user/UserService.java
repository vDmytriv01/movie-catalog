package com.team200.moviecatalog.service.user;

import com.team200.moviecatalog.dto.user.ChangePasswordRequestDto;
import com.team200.moviecatalog.dto.user.UpdateAvatarResponseDto;
import com.team200.moviecatalog.dto.user.UpdateUserRequestDto;
import com.team200.moviecatalog.dto.user.UserRegisterRequestDto;
import com.team200.moviecatalog.dto.user.UserResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    UserResponseDto registration(UserRegisterRequestDto requestDto);

    UserResponseDto getCurrentUser(String email);

    UserResponseDto updateUser(String email, UpdateUserRequestDto dto);

    UpdateAvatarResponseDto updateAvatar(String email, MultipartFile file);

    void changePassword(String email, ChangePasswordRequestDto dto);

    void deleteUser(String email);
}
