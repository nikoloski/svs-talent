package com.seavus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);
        BookRepository book = ctx.getBean(BookRepository.class);

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
                    book.save(new Book(isbn, title));
                    break;
                case "list":
                    Iterable<Book> books = book.findAll();
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

        ((ConfigurableApplicationContext) ctx).close();
        System.exit(0);
    }
}
