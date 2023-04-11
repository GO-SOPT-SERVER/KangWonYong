package com.sopt.kwy.soptseminar;

import com.sopt.kwy.soptseminar.domain.Book;
import com.sopt.kwy.soptseminar.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SoptSeminarApplication {
    public static ArrayList<User> userList;
    public static ArrayList<Book> books;

    public static void main(String[] args) {
        SpringApplication.run(SoptSeminarApplication.class, args);
        userList = new ArrayList<>();
        books = new ArrayList<>();
    }

}
