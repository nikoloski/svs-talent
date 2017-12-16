package com.seavus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void init() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
            System.out.println("Choose action:");
            String number = input.nextLine();
            switch (number) {
                case "register":
                    System.out.println("Insert isbn:");
                    String isbn = input.nextLine();
                    System.out.println("Insert title:");
                    String title = input.nextLine();
                    bookRepository.save(new Book(isbn, title));
                    break;
                case "list":
                    Iterable<Book> books = bookRepository.findAll();
                    for (Book book1 : books) {
                        System.out.println(book1.toString());
                    }
                    break;
                case "exit":
                    flag = false;
                    System.out.println("Leaving application!");
                    break;
                default:
                    System.out.println("Invalid input, try again!");
                    break;
            }
        }
    }
}
