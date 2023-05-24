package com.sopt.kwy.soptseminar.controller.book.response;

import com.sopt.kwy.soptseminar.domain.Book;
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

    public static BookResponseDto toResponseDto(Book book) {
        return new BookResponseDto(book.getId(), book.getTitle(), book.getCode());
    }
}
