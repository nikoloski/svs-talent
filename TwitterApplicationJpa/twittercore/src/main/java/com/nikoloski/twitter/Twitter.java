package com.nikoloski.twitter;

import com.nikoloski.association.usertweet.UserTweets;
import com.nikoloski.association.useruser.UserFollows;
import com.nikoloski.entity.user.User;
import com.nikoloski.entityservice.TweetUserService;
import com.nikoloski.entityservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Twitter {

    private static String signedInUserEmail = null;
    private UserService userService;
    private UserTweets userTweets;
    private UserFollows userFollows;
    private TweetUserService tweetUserService;
    private boolean flag = true;
    private String email, message;

    @Autowired
    public Twitter(UserService userService, UserTweets userTweets, UserFollows userFollows, TweetUserService tweetUserService) {
        this.userService = userService;
        this.userTweets = userTweets;
        this.userFollows = userFollows;
        this.tweetUserService = tweetUserService;
    }

    public void initTwitterApplication() {
        while (flag) {
            System.out.println("Choose your action: ");
            Scanner input = new Scanner(System.in);
            String action = input.nextLine();
            switch (action) {
                case "signup":
                    if (signedInUserEmail != null) {
                        System.out.println("Someone is already signed in, try signing out and then signing up!");
                    } else {
                        System.out.println("Your email: ");
                        email = input.nextLine();
                        if (userService.signUpUser(new User(email))) {
                            System.out.println("Thank you for signing up!");
                            signedInUserEmail = email;
                        } else {
                            System.out.println("A user with this email has already been registered. Try again!");
                        }
                    }
                    break;
                case "signin":
                    if (signedInUserEmail != null) {
                        System.out.println("Someone is already signed in, try signing out and then signing in!");
                    } else {
                        System.out.println("Your email: ");
                        email = input.nextLine();
                        if (userService.userExist(email)) {
                            signedInUserEmail = email;
                            System.out.println("You have been signed in successfuly!");
                        } else {
                            System.out.println("A user with this email is not registered. Try again!");
                        }
                    }
                    break;
                case "signout":
                    if (signedInUserEmail != null) {
                        signedInUserEmail = null;
                        System.out.println("You have been signed out successfuly!");
                    } else {
                        System.out.println("Nobody is signed in. Try again!");
                    }
                    break;
                case "follow":
                    if (signedInUserEmail != null) {
                        System.out.println("Insert the email of the user you want to follow: ");
                        email = input.nextLine();
                        if (signedInUserEmail.equals(email)) {
                            System.out.println("You cannot follow yourself. Try again!");
                        } else {
                            userFollows.userFollowsUser(signedInUserEmail, email);
                        }
                    } else {
                        System.out.println("To follow user, you must be signed in. Try again!");
                    }
                    break;
                case "tweet":
                    if (signedInUserEmail != null) {
                        System.out.println("Your message: ");
                        message = input.nextLine();
                        userTweets.userCreatesTweet(signedInUserEmail, message);
                    } else {
                        System.out.println("To tweet a message, you must be signed in. Try again!");
                    }
                    break;
                case "list tweets":
                    if (signedInUserEmail != null) {
                        tweetUserService.listTweetsFromFollowingUsers(signedInUserEmail);
                    } else {
                        System.out.println("To list the tweets, you must be signed in. Try again!");
                    }
                    break;
                case "exit":
                    flag = false;
                    System.out.println("Exiting the application..");
                    break;
                default:
                    System.out.println("Invalid action, try again!");
                    break;
            }
        }
    }
}
