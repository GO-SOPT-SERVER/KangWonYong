package com.sopt.kwy.soptseminar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/member/{memberId}")
    public String hello(@PathVariable final Long memberId) {
        return "Hello World";
    }
}
