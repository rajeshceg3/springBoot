package com.springboot.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer{

    @KafkaListener(topics="imdb", groupID="group_id")
    public void consume(String msg){
        System.out.println("Message received from Kafka is " + msg);
    }
}