package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener{

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message){
        System.out.println(message);
    }
}