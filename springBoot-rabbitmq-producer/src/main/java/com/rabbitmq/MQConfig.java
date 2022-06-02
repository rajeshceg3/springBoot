package com.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig{

    public static final QUEUE = "message_queue"
    public static final EXCHANGE = "message_exchange"
    public static final ROUTING_KEY = "message_routingkey"

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }


    public Binding binding(Queue queue, TopicExchange exchange){
            return BindingBuilder
                    .bind(queue)
                    .to(exchange)
                    .with(ROUTING_KEY);
    }


}