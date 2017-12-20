package com.seavus.entity.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seavus.entity.member.Member;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String isbn;
    private String title;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Collection<Member> members;

    public Book(){}

    public Book(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Member> getMembers() { return members; }

}
