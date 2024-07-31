package com.haydikodlayalim.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.haydikodlayalim.config.RabbitMqConfig;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}
