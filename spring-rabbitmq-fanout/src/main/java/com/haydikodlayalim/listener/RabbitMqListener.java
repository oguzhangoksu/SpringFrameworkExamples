package com.haydikodlayalim.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.haydikodlayalim.config.RabbitMqConfig;

@Component
public class RabbitMqListener {
    
    
    @RabbitListener(queues = RabbitMqConfig.QUEUE_ONE)
    public void listenQueueOne(String message) {
        System.out.println("Queue One Listener received message: " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_ONE)
    public void listenQueueOneTwo(String message) {
        System.out.println("Queue One Listener Two received message: " + message);
    }
    @RabbitListener(queues = RabbitMqConfig.QUEUE_TWO)
    public void listenQueueTwo(String message) {
        System.out.println("Queue Two Listener received message: " + message);
    }

}
