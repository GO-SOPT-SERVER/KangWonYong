package com.sopt.kwy.soptseminar.controller.user;

import com.sopt.kwy.soptseminar.common.dto.ApiResponseDto;
import com.sopt.kwy.soptseminar.controller.user.dto.request.UserReqDto;
import com.sopt.kwy.soptseminar.exception.SuccessStatus;
import com.sopt.kwy.soptseminar.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto registerUser(@RequestBody @Valid UserReqDto body) {
        userService.registerUser(body);
        return ApiResponseDto.success(SuccessStatus.POST_CREATED_SUCCESS);
    }
}
