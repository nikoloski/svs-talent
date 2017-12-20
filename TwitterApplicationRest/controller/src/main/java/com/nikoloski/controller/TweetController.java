package com.nikoloski.controller;

import com.nikoloski.entity.tweet.Tweet;
import com.nikoloski.service.ListTweetsService;
import com.nikoloski.service.UserTweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    private SignedInUserController signedInUserController;
    private ListTweetsService listTweetsService;
    private UserTweetsService userTweetsService;

    @Autowired
    public TweetController(SignedInUserController signedInUserController, ListTweetsService listTweetsService, UserTweetsService userTweetsService) {
        this.signedInUserController = signedInUserController;
        this.listTweetsService = listTweetsService;
        this.userTweetsService = userTweetsService;
    }


    @PostMapping
    public void userTweets(@RequestBody Tweet tweet) {
        if (signedInUserController.getSignedInUserEmail() != null) {
            userTweetsService.userTweets(signedInUserController.getSignedInUserEmail(), tweet.getMessage());
        } else {
            System.out.println("To tweet a message, you must be signed in. Try again!");
        }
    }

    @GetMapping
    public Collection<Tweet> listTweets() {
        if (signedInUserController.getSignedInUserEmail() != null) {
            return listTweetsService.listTweets(signedInUserController.getSignedInUserEmail());
        } else {
            System.out.println("To list the tweets, you must be signed in. Try again!");
            return null;
        }
    }
}
