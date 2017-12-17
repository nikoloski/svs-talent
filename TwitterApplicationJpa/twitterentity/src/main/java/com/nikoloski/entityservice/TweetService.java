package com.nikoloski.entityservice;

import com.nikoloski.entity.tweet.Tweet;
import com.nikoloski.entity.tweet.TweetRepository;
import com.nikoloski.entity.user.User;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TweetService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void listTweets(Collection<User> users) {
        for (User user : users) {
            System.out.println("User: " + user.getEmail());
            Collection<Tweet> tweets = tweetRepository.findByUser(userRepository.findByEmail(user.getEmail()));
            Tweet[] orderedTweets = tweets.toArray(new Tweet[tweets.size()]);
            for (int i = orderedTweets.length - 1; i >= 0; i--) {
                System.out.println(orderedTweets[i].toString());
            }
        }
    }
}
