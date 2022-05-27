package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Startup implements CommandLineRunner{

@Autowired
UserRepository userRepository;

@Override
public voic run(String... args) throws Exception {
    Stream.of("IronMan", "SpiderMan", "WonderWoman")
        .forEach( name ->
            userRepository.save( new User(name))
        );
}
}