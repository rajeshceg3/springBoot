package com.jwt.app;

import com.jwt.app.model.User;
import com.jwt.app.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(UserDetailsServiceImpl userDetailsService) {
		return args -> {
			// Add a default user
			userDetailsService.addUser(new User(1L, "user", passwordEncoder.encode("password")));
		};
	}
}
