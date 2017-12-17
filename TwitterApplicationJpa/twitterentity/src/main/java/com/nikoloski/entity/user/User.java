package com.nikoloski.entity.user;

import com.nikoloski.entity.tweet.Tweet;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    @OneToMany(mappedBy = "user")
    private Collection<Tweet> tweets;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> following;

    @ManyToMany(mappedBy = "following", fetch = FetchType.EAGER)
    private Collection<User> followers;

    public User () {}

    public User(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Collection<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Collection<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Collection<User> followers) {
        this.followers = followers;
    }

    public Collection<User> getFollowing() {
        return following;
    }

    public void setFollowing(Collection<User> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
