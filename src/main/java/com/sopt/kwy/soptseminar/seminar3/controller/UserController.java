package com.sopt.kwy.soptseminar.seminar3.controller;

import com.sopt.kwy.soptseminar.seminar3.common.dto.ApiResponseDto;
import com.sopt.kwy.soptseminar.seminar3.controller.dto.request.UserRequestDto;
import com.sopt.kwy.soptseminar.seminar3.controller.dto.response.UserResponseDto;
import com.sopt.kwy.soptseminar.seminar3.exception.SuccessStatus;
import com.sopt.kwy.soptseminar.seminar3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }
}
