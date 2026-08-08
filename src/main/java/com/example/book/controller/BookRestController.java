package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {

        return bookService.getBooks();
    }

    @PostMapping
    public Book addBook(
            @RequestBody Book book
    ) {

        bookService.addBook(book);

        return book;
    }
}