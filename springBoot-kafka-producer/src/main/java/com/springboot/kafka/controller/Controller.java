package com.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.kafka.model.Movie;

@RestController
public class Controller{

@Autowired
KafkaTemplate<String, Movie> kafkaTemplate;

private static final String TOPIC = "imdb";

@PostMapping("/publish")
public String publish(@RequestBody Movie movie){
    kafkaTemplate.send(TOPIC, movie);
    return "Message published";
}

}