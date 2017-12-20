package com.nikoloski.entity.tweet;

import com.nikoloski.entity.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private long id;

    private String message;
    private Date date;

    @ManyToOne
    private User user;

    public Tweet() {
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tweet: ");
        sb.append(getMessage());
        sb.append("\t Date create: ");
        sb.append(getDate());

        return sb.toString();
    }
}
