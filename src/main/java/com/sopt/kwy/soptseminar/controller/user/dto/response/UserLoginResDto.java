package com.sopt.kwy.soptseminar.controller.user.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginResDto {
    private Long userId;
    private String accessToken;

    public static UserLoginResDto of(Long userId, String accessToken) {
        return new UserLoginResDto(userId, accessToken);
    }
}
