package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> users(){
        return userRepository.findAll();
    }
    

}