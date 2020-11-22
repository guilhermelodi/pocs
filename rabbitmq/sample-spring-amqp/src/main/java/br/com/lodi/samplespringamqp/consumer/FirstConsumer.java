package br.com.lodi.samplespringamqp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import br.com.lodi.samplespringamqp.config.QueueConfig;

@Slf4j
@Component
public class FirstConsumer {

    @RabbitListener(queues = QueueConfig.FIRST_QUEUE_NAME)
    public void consumeFromFirstQueue(final Message message) {
        log.info("consuming message from {}", message.getMessageProperties().getConsumerQueue());
        String valueMessage = new String(message.getBody());
        log.info("First Queue - Message consumed='{}'", valueMessage);
    }


}
