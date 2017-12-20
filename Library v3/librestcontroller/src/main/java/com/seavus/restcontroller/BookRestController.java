package com.seavus.restcontroller;

import com.seavus.entity.book.Book;
import com.seavus.service.entityservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.registerBook(book);
    }
}
