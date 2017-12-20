package com.nikoloski.service;

import com.nikoloski.entity.tweet.Tweet;
import com.nikoloski.entity.tweet.TweetRepository;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTweetsService {

    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public UserTweetsService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public void userTweets(String email, String message) {
        Tweet tweet = new Tweet(message, new Date());
        tweet.setUser(userRepository.findByEmail(email));
        tweetRepository.save(tweet);
    }
}
