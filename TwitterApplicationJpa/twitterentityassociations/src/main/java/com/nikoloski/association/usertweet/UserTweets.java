package com.nikoloski.association.usertweet;

import com.nikoloski.entity.tweet.Tweet;
import com.nikoloski.entity.tweet.TweetRepository;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTweets {

    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    public UserTweets(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public void userCreatesTweet(String email, String message){
        Tweet tweet = new Tweet(message, new Date());
        tweet.setUser(userRepository.findByEmail(email));
        tweetRepository.save(tweet);
    }
}
