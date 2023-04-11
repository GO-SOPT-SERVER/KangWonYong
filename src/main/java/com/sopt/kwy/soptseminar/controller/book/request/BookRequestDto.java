package com.sopt.kwy.soptseminar.controller.book.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookRequestDto {
    private String title;
    private String code;
}
