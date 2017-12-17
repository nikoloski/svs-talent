package com.seavus.entity.member;

import com.seavus.entity.book.Book;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Book> books;

    public Member(){}

    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Member id: " + id);
        sb.append(" email: " + email);
        sb.append(" name: " + name);
        if (books.size() > 0) {
            sb.append("\nMembers: [");
            for (Book book : books) {
                sb.append("\nBook id: " + book.getId());
                sb.append(" isbn: " + book.getIsbn());
                sb.append(" title: " + book.getTitle());
            }
            sb.append("\n]");
        } else {
            sb.append("\nNo book was lent by this member.");
        }
        return sb.toString();
    }
}
