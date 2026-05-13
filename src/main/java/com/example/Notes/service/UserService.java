package com.example.Notes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notes.entity.User;
import com.example.Notes.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String registerUser(User user) {
        Optional<User> existingUser = (Optional<User>) userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return "Email already in use";
        } else {
            userRepository.save(user);
            return "User registered successfully";
        }
    }

    public String loginUser(User user) {
        Optional<User> existingUser = (Optional<User>) userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            User existingUserData = existingUser.get();
            if (existingUserData.getPassword().equals(user.getPassword())) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }

}
