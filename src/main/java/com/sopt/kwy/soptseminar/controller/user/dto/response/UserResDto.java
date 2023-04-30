package com.sopt.kwy.soptseminar.controller.user.dto.response;

import com.sopt.kwy.soptseminar.domian.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResDto {
    private Long id;
    private String nickname;

    public static UserResDto to(User user) {
        return new UserResDto(user.getId(), user.getNickname());
    }
}
