package com.greenfoxacademy.demo.contorllers;


import com.greenfoxacademy.demo.models.User;
import com.greenfoxacademy.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserRest {

    private final UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api")
    public ArrayList<User> getUsers() {
        return userService.getAllUser();
    }

}
