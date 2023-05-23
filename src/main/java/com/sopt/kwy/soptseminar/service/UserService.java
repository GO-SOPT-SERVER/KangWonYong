package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.common.exception.SoptBadRequestException;
import com.sopt.kwy.soptseminar.common.exception.SoptConflictException;
import com.sopt.kwy.soptseminar.common.exception.SoptNotFoundException;
import com.sopt.kwy.soptseminar.controller.user.dto.request.UserReqDto;
import com.sopt.kwy.soptseminar.domian.User;
import com.sopt.kwy.soptseminar.exception.ErrorStatus;
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
        User existNameUser = userRepository.findByAndNicknameOrEmail(body.getNickname(), body.getEmail());
        if (existNameUser != null) {
            if (existNameUser.getNickname().equals(body.getNickname()))
                throw new SoptConflictException(ErrorStatus.CONFLICT_NICKNAME_EXCEPTION);
            else if (existNameUser.getEmail().equals(body.getEmail()))
                throw new SoptConflictException(ErrorStatus.CONFLICT_EMAIL_EXCEPTION);
        }
        User newUser = User.builder()
                .email(body.getEmail())
                .nickname(body.getNickname())
                .password(body.getPassword())
                .build();
        userRepository.save(newUser);
    }

    @Transactional
    public Long login(UserReqDto body) {
        User user = userRepository.findByEmail(body.getEmail())
                .orElseThrow(() -> new SoptNotFoundException(ErrorStatus.NOT_FOUND_USER_EXCEPTION));
        if (!user.getPassword().equals(body.getPassword())) {
            throw new SoptBadRequestException(ErrorStatus.INVALID_PASSWORD_EXCEPTION);
        }

        return user.getId();
    }
}
