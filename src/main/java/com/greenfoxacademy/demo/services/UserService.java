package com.greenfoxacademy.demo.services;

import com.greenfoxacademy.demo.models.User;
import com.greenfoxacademy.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.getByName(name);
    }

    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) userRepository.findAll();
    }
}
