package com.haydikodlayalim.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String FANOUT_EXCHANGE = "fanout-exchange";
    public static final String QUEUE_ONE = "queue-one";
    public static final String QUEUE_TWO = "queue-two";


     @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE, false);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueOne(@Qualifier("queueOne") Queue queueOne, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueOne).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueueTwo(@Qualifier("queueTwo") Queue queueTwo, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueTwo).to(fanoutExchange);
    }
}
