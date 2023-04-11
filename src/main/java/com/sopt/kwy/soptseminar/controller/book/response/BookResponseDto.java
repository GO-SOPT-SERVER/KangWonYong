package com.sopt.kwy.soptseminar.controller.book.response;

import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String code;

    public BookResponseDto(Long id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code = code;
    }
}
