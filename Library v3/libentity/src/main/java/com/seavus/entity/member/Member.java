package com.seavus.entity.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToMany
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

}
