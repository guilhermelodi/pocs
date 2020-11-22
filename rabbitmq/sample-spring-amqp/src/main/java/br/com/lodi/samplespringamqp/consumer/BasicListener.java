package br.com.lodi.samplespringamqp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BasicListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.info("consuming message from {}", message.getMessageProperties().getConsumerQueue());
        String valueMessage = new String(message.getBody());
        log.info("BasicListener - Message consumed='{}'", valueMessage);
    }

}
