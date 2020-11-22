package br.com.lodi.samplespringamqp.config;

import br.com.lodi.samplespringamqp.consumer.BasicListener;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SecondQueueConsumerConfig {

    private final ConnectionFactory connectionFactory;
    private final BasicListener basicListener;
    private final SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;

    @Bean
    public MessageListenerContainer listenerContainer() {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QueueConfig.SECOND_QUEUE_NAME);
        container.setMessageListener(basicListener);

        return container;
    }

}
