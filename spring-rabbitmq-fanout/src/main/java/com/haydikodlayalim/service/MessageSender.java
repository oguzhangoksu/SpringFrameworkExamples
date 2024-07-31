package com.haydikodlayalim.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.haydikodlayalim.config.RabbitMqConfig.FANOUT_EXCHANGE;

@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "", message);
    }
}