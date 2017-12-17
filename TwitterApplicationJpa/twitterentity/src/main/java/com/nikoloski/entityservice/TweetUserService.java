package com.nikoloski.entityservice;

import com.nikoloski.entity.user.User;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TweetUserService {

    private UserRepository userRepository;
    private TweetService tweetService;

    public TweetUserService(UserRepository userRepository, TweetService tweetService) {
        this.userRepository = userRepository;
        this.tweetService = tweetService;
    }

    public void listTweetsFromFollowingUsers(String email) {
        User user = userRepository.findByEmail(email);
        tweetService.listTweets(user.getFollowing());
    }
}
