package com.haydikodlayalim.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haydikodlayalim.config.RabbitMqConfig;

@RestController
public class MessageController {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        System.out.println("Sending message..."+message);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.RoutingKey, message);
        return "Message sent to RabbitMQ: " + message;
    }

}