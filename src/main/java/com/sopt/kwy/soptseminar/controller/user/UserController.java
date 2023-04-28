package com.sopt.kwy.soptseminar.controller.user;


import com.sopt.kwy.soptseminar.controller.user.dto.request.RegisterRequestDto;
import com.sopt.kwy.soptseminar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.sopt.kwy.soptseminar.SoptSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public String register(@RequestBody final RegisterRequestDto request) {
        Long userId = userService.register(request);
        System.out.println(userList.get(userId.intValue() - 1).toString());

        return "유저 등록이 완료됐습니다.";
    }

    @GetMapping("/{userId}")
    public String getOne(@PathVariable final Long userId) {
        System.out.println("요청 유저 아이디: " + userId);

        // 서비스 계층에서 유저 아이디로 유저를 찾는 메서드 호출

        return "유저 조회 성공";
    }

    @GetMapping("/search")
    public String search(@RequestParam final String name) {
        System.out.println("유저 이름 검색 인자: " + name);

        // 서비스 계층에서 유저 닉네임으로 유저를 찾는 메서드 호출

        return "유저 검색 성공";
    }
}
