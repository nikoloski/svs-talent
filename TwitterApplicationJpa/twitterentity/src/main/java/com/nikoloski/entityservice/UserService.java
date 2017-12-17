package com.nikoloski.entityservice;

import com.nikoloski.entity.user.User;
import com.nikoloski.entity.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean signUpUser(User user) {
        if (userExist(user.getEmail())) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    public boolean userExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

}
