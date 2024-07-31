/*package com.haydikodlayalim.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.haydikodlayalim.config.RabbitMqConfig;

@Component
public class QueueTwoListener {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_TWO)
    public void listenQueueTwo(String message) {
        System.out.println("Queue Two Listener received message: " + message);
    }
}*/