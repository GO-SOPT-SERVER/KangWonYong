package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.controller.book.request.BookRequestDto;
import com.sopt.kwy.soptseminar.controller.book.response.BookResponseDto;
import com.sopt.kwy.soptseminar.domain.Book;
import org.springframework.stereotype.Service;

import static com.sopt.kwy.soptseminar.SoptSeminarApplication.books;

@Service
public class BookService {
    public Long register(BookRequestDto body) {
        Book newBook = new Book(
                body.getTitle(),
                body.getCode()
        );
        books.add(newBook);
        newBook.setId(books.size());

        return newBook.getId();
    }

    public BookResponseDto getBook(int id) {
        return books.get(id - 1).toResponse();
    }

    public BookResponseDto searchBook(String name) {
        return books.stream()
                .filter(book -> book.getTitle().equals(name))
                .findAny()
                .map(book -> book.toResponse())
                .get();
    }
}
