package br.com.lodi.samplespringamqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    public static final String FIRST_QUEUE_NAME = "first-queue";

    public static final String SECOND_QUEUE_NAME = "second-queue";

    public static final String MOVIE_QUEUE_NAME = "movie-queue";

    @Bean
    public Queue firstQueue() {
        return QueueBuilder
                .durable(FIRST_QUEUE_NAME)
                .build();
    }

    @Bean
    public Queue secondQueue() {
        return QueueBuilder
                .durable(SECOND_QUEUE_NAME)
                .build();
    }

    @Bean
    public Queue movieQueue() {
        return QueueBuilder
                .durable(MOVIE_QUEUE_NAME)
                .build();
    }

}
