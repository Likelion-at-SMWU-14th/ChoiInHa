package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String books(Model model) {

        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("book", new Book());

        return "books";
    }

    @PostMapping
    public String addBook(Book book) {

        bookService.addBook(book);

        return "redirect:/books";
    }
}