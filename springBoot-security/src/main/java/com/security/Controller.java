package com.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome to user page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin page";
    }

}
