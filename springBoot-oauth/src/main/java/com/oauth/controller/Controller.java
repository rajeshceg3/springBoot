package com.oauth.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class Controller{

@GetMapping("/")
public String home(Principal principal){
    Map<String, Object> authInfo = (Map<String, Object>) ((OAuth2Authentication) principal)
            .getUserAuthentication()
            .getDetails();

    return "Hello " + authInfo.get("name") + " Welcome to the app";
}
}