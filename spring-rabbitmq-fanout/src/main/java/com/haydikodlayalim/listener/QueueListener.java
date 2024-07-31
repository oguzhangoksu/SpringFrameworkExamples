/*package com.haydikodlayalim.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.haydikodlayalim.config.RabbitMqConfig;

@Component
public class QueueListener {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_ONE)
    public void listenQueueOne(String message) {
        System.out.println("Queue One Listener received message: " + message);
    }
}*/
