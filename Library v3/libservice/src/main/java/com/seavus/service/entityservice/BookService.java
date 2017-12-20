package com.seavus.service.entityservice;


import com.seavus.entity.book.Book;
import com.seavus.entity.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> listBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
