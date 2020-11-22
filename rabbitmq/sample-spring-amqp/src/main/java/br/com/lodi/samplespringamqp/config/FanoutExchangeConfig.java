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
public class FanoutExchangeConfig {

    public static final String NAME = "FANOUT-EXCHANGE-SPRING-AMQP";

    private final Queue firstQueue;

    private final Queue secondQueue;

    @Bean
    public Exchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange(NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstFanoutBinding() {
        return BindingBuilder
                .bind(firstQueue)
                .to(fanoutExchange())
                .with("")
                .noargs();
    }

    @Bean
    public Binding secondFanoutBinding() {
        return BindingBuilder
                .bind(secondQueue)
                .to(fanoutExchange())
                .with("")
                .noargs();
    }

}
