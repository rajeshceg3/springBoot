package com.bank.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // This service is a placeholder for JWT validation.
        // It's not meant to load users from a database.
        // Return a dummy UserDetails if a username is provided,
        // or throw an exception if that's more appropriate for your filter logic.
        // For now, let's assume the filter will handle username extraction and validation.
        // If Spring Security requires a non-null UserDetails for UsernamePasswordAuthenticationToken,
        // we can return a default one.
        if (username != null && !username.isEmpty()) {
            return new User(username, "", new ArrayList<>()); // password can be empty as it's not used for JWT auth
        } else {
            throw new UsernameNotFoundException("Username cannot be null or empty for JWT validation context.");
        }
    }
}
