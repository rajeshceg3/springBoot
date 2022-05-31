package com.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class Controller{

@Autowired
private RabbitTemplate rabbitTemplate;

@PostMapping("/publish")
public String publish(@RequestBody Message msg){
    msg.setMsgId(UUID.randomUUID().toString());
    msg.setMsgDate( new Date());
    //
    return "Message sent";
}
}