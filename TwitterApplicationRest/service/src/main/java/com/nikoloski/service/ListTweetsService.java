package com.nikoloski.service;

import com.nikoloski.entity.tweet.Tweet;
import com.nikoloski.entity.tweet.TweetRepository;
import com.nikoloski.entity.user.User;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListTweetsService {

    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public ListTweetsService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> listTweets(String email) {
        List<Tweet> tweetsToBeReturned = new ArrayList<Tweet>();
        User signedInUser = userRepository.findByEmail(email);
        for (User user : signedInUser.getFollowing()) {
            List<Tweet> tweets = tweetRepository.findByUser(userRepository.findByEmail(user.getEmail()));
            for (Tweet tweet : tweets) {
                tweetsToBeReturned.add(tweet);
            }
        }
        return tweetsToBeReturned;
    }
}
