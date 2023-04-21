package com.sopt.kwy.soptseminar.domain;

import lombok.Getter;

@Getter
public class Book {
    private Long id;
    private String title;
    private String code;

    public Book(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" + "title: " + this.title + "\n" + "code: " + this.code + "\n";
    }
}
