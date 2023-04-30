package com.sopt.kwy.soptseminar.seminar3.service;

import com.sopt.kwy.soptseminar.seminar3.controller.dto.request.UserRequestDto;
import com.sopt.kwy.soptseminar.seminar3.controller.dto.response.UserResponseDto;
import com.sopt.kwy.soptseminar.seminar3.domain.User;
import com.sopt.kwy.soptseminar.seminar3.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();
        userRepository.save(user);
        return UserResponseDto.of(user.getId(), user.getNickname());
    }
}
