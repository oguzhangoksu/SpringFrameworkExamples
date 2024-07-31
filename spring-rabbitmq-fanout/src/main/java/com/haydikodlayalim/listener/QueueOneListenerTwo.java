/*package com.haydikodlayalim.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.haydikodlayalim.config.RabbitMqConfig;

@Component
public class QueueOneListenerTwo {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_ONE)
    public void listenQueueOneTwo(String message) {
        System.out.println("Queue One Listener Two received message: " + message);
    }
}*/