package com.seavus.entity.book;

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

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book id: " + id);
        sb.append(" isbn: " + isbn);
        sb.append(" title: " + title);
        if (members.size() > 0) {
            sb.append("\nMembers: [");
            for (Member member : members) {
                sb.append("\nMember id: " + member.getId());
                sb.append(" email: " + member.getEmail());
                sb.append(" name: " + member.getName());
            }
            sb.append("\n]");
        }else {
            sb.append("\nThis book wasn't lent by any user.");
        }
        return sb.toString();
    }
}
