package com.example.helloworld.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueConfig {
    @Bean
    public Queue getQueue() {
        return new Queue("test-jpl", true);
    }
}
