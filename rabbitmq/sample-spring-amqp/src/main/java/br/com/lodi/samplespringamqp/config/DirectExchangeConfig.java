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
public class DirectExchangeConfig {

    public static final String NAME = "DIRECT-EXCHANGE-SPRING-AMQP";

    private final Queue firstQueue;

    private final Queue secondQueue;

    private final Queue movieQueue;

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange(NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstDirectBinding() {
        return BindingBuilder
                .bind(firstQueue)
                .to(directExchange())
                .with("first")
                .noargs();
    }

    @Bean
    public Binding secondDirectBinding() {
        return BindingBuilder
                .bind(secondQueue)
                .to(directExchange())
                .with("second")
                .noargs();
    }

    @Bean
    public Binding movieDirectBinding() {
        return BindingBuilder
                .bind(movieQueue)
                .to(directExchange())
                .with("movie")
                .noargs();
    }

}
