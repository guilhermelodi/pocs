package br.com.lodi.samplespringamqp.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class TopicExchangeConfig {

    public static final String NAME = "TOPIC-EXCHANGE-SPRING-AMQP";

    private final Queue firstQueue;

    private final Queue secondQueue;

    @Bean
    public Exchange topicExchange() {
        return ExchangeBuilder
                .topicExchange(NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstTopicBinding() {
        return BindingBuilder
                .bind(firstQueue)
                .to(topicExchange())
                .with("first.#")
                .noargs();
    }

    @Bean
    public Binding secondTopicBinding() {
        return BindingBuilder
                .bind(secondQueue)
                .to(topicExchange())
                .with("second.#")
                .noargs();
    }

}
