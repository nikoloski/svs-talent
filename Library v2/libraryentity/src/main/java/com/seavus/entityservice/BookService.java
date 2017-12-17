package com.seavus.entityservice;

import com.seavus.entity.book.Book;
import com.seavus.entity.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerBook(Book book) {
        bookRepository.save(book);
        System.out.println("The book was registered.");
    }

    public void listBooks() {
        Iterable<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
