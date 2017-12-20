package com.seavus.service.associationservice;

import com.seavus.entity.book.Book;
import com.seavus.entity.book.BookRepository;
import com.seavus.entity.member.Member;
import com.seavus.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendBookService {

    BookRepository bookRepository;
    MemberRepository memberRepository;

    @Autowired
    public LendBookService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public void lendBook(String email, String isbn) {
        Member member = getMember(email);
        Book book = getBook(isbn);
        if (member != null) {
            if (book != null) {
                member.getBooks().add(book);
                memberRepository.save(member);
                System.out.println("The lending was successful!");
            } else {
                System.out.println("Such book doesn't exist. Try again!");
                return;
            }
        } else {
            System.out.println("Such member doesn't exist. Try again!");
            return;
        }
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email);
    }

    public Book getBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
