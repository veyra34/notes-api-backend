package com.example.Notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes.entity.User;
import com.example.Notes.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     UserService userService;

     @PostMapping("/register")
     public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
     }
      @PostMapping("/login")
     public String loginUser(@RequestBody User user) {
        return userService.loginUser(user);
     }

    
}
