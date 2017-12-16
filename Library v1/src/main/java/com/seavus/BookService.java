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
        displayMenu();
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
            System.out.println("Choose action:");
            String action = input.nextLine();
            switch (action) {
                case "rg":
                    System.out.println("Insert isbn:");
                    String isbn = input.nextLine();
                    System.out.println("Insert title:");
                    String title = input.nextLine();
                    bookRepository.save(new Book(isbn, title));
                    break;
                case "ls":
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

    public void displayMenu() {
        System.out.println("Welcome to Darko Nikoloski's Library Application!");
        System.out.println("When asked for action choose between the following:");
        System.out.println("1. rg - to register a book;\n2. ls - to list all books;\n3. exit - to stop the application.");
    }
}
