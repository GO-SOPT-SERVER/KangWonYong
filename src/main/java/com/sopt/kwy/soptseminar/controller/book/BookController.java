package com.sopt.kwy.soptseminar.controller.book;

import com.sopt.kwy.soptseminar.controller.book.request.BookRequestDto;
import com.sopt.kwy.soptseminar.controller.book.response.BookResponseDto;
import com.sopt.kwy.soptseminar.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.sopt.kwy.soptseminar.SoptSeminarApplication.books;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public String register(@RequestBody final BookRequestDto request) {
        Long bookId = bookService.register(request);
        System.out.println(books.get(bookId.intValue() - 1).toString());
        return "책 등록 완료";
    }

    @GetMapping("/{bookId}")
    public BookResponseDto getBook(@PathVariable final Long bookId) {
        return bookService.getBook(bookId.intValue());
    }

    @GetMapping("/search")
    public BookResponseDto search(@RequestParam final String name) {
        System.out.println("유저 이름 검색 인자: " + name);
        return bookService.searchBook(name);
    }
}
