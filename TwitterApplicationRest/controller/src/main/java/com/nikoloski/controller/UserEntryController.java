package com.nikoloski.controller;

import com.nikoloski.entity.user.User;
import com.nikoloski.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEntryController {

    private RegisterUserService registerUserService;
    private SignedInUserController signedInUserController;

    @Autowired
    public UserEntryController(RegisterUserService registerUserService, SignedInUserController signedInUserController) {
        this.registerUserService = registerUserService;
        this.signedInUserController = signedInUserController;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        if (signedInUserController.getSignedInUserEmail() == null) {
            if (registerUserService.signUpUser(user)) {
                System.out.println("Thank you for signing up!");
            } else {
                System.out.println("A user with this email has already been registered. Try again!");
            }
        } else {
            System.out.println("Someone is already signed in, try signing out and then signing up!");
        }
    }

    @PostMapping("/signin")
    public void signIn(@RequestBody User user) {
        if (signedInUserController.getSignedInUserEmail() != null) {
            System.out.println("Someone is already signed in, try signing out and then signing in!");
        } else {
            if (registerUserService.userExist(user.getEmail())) {
                signedInUserController.setSignedInUserEmail(user.getEmail());
                System.out.println("You have been signed in successfuly!");
            } else {
                System.out.println("A user with this email is not registered. Try again!");
            }
        }
    }

    @GetMapping("/signout")
    public void signOut() {
        if (signedInUserController.getSignedInUserEmail() != null) {
            signedInUserController.setSignedInUserEmail(null);
            System.out.println("You have been signed out successfuly!");
        } else {
            System.out.println("Nobody is signed in. Try again!");
        }
    }

}
