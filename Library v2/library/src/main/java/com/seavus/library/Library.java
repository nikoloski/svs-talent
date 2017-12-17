package com.seavus.library;

import com.seavus.association.bookmember.LendBook;
import com.seavus.entity.book.Book;
import com.seavus.entityservice.BookService;
import com.seavus.entity.member.Member;
import com.seavus.entityservice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Library {

    private BookService bookService;
    private MemberService memberService;
    private LendBook lendBook;

    @Autowired
    public Library(BookService bookService, MemberService memberService, LendBook lendBook) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.lendBook = lendBook;
    }

    public void init() {
        displayMenu();

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String isbn, title, email, name;

        while (flag) {
            System.out.println("Choose action:");
            String action = input.nextLine();
            switch (action) {
                case "rg book":
                    System.out.println("Insert isbn:");
                    isbn = input.nextLine();
                    System.out.println("Insert title:");
                    title = input.nextLine();
                    bookService.registerBook(new Book(isbn, title));
                    break;
                case "ls book":
                    bookService.listBooks();
                    break;
                case "rg member":
                    System.out.println("Insert email:");
                    email = input.nextLine();
                    System.out.println("Insert name:");
                    name = input.nextLine();
                    memberService.registerMember(new Member(email, name));
                    break;
                case "ls member":
                    memberService.listMembers();
                    break;
                case "ld book":
                    System.out.println("Insert member email:");
                    email = input.nextLine();
                    System.out.println("Insert book isbn:");
                    isbn = input.nextLine();;
                    lendBook.lendBook(email, isbn);
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
        System.out.println("1. rg book - to register a book;\n2. ls book - to list all books;");
        System.out.println("3. rg member - to register a member;\n4. ls member - to list all members;");
        System.out.println("5. ld book - to lend a book to a member;\n6. exit - to stop the application.");
    }
}
