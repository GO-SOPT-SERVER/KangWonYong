package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.controller.user.dto.request.UserReqDto;
import com.sopt.kwy.soptseminar.domian.User;
import com.sopt.kwy.soptseminar.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void registerUser(UserReqDto body) {
        User newUser = User.builder()
                .email(body.getEmail())
                .nickname(body.getNickname())
                .password(body.getPassword())
                .build();
        userRepository.save(newUser);
    }
}
