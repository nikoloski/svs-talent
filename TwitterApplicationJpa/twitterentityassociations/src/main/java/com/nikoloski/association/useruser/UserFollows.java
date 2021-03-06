package com.nikoloski.association.useruser;

import com.nikoloski.entity.user.User;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFollows {

    private UserRepository userRepository;

    public UserFollows(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userFollowsUser(String emailOfSignedUser, String emailOfUserToBeFollowed) {
        User userSigned = userRepository.findByEmail(emailOfSignedUser);
        User userToBeFollowed = userRepository.findByEmail(emailOfUserToBeFollowed);
        if (userToBeFollowed != null) {
            for (User user : userSigned.getFollowing()) {
                if (user.getEmail().equals(userToBeFollowed.getEmail())) {
                    System.out.println("You already followed this user. Try again!");
                    return;
                }
            }
            userSigned.getFollowing().add(userToBeFollowed);
            userRepository.save(userSigned);
            System.out.println("The user has been followed!");
        } else {
            System.out.println("The user you want to follow doesn't exist. Try again!");
        }
    }
}
