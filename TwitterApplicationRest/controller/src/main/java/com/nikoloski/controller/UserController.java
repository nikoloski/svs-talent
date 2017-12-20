package com.nikoloski.controller;

import com.nikoloski.entity.user.User;
import com.nikoloski.service.UserFollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/follow")
public class UserController {

    private UserFollowsService userFollowsService;
    private SignedInUserController signedInUserController;

    @Autowired
    public UserController(UserFollowsService userFollowsService, SignedInUserController signedInUserController) {
        this.userFollowsService = userFollowsService;
        this.signedInUserController = signedInUserController;
    }

    @PostMapping
    public void follow(@RequestBody User user) {
        if (signedInUserController.getSignedInUserEmail() != null) {
            if (signedInUserController.getSignedInUserEmail().equals(user.getEmail())) {
                System.out.println("You cannot follow yourself. Try again!");
            } else {
                userFollowsService.userFollowsUser(signedInUserController.getSignedInUserEmail(), user.getEmail());
            }
        } else {
            System.out.println("To follow user, you must be signed in. Try again!");
        }
    }
}
