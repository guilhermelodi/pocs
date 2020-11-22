package br.com.lodi.samplespringamqp.consumer;

import br.com.lodi.samplespringamqp.config.QueueConfig;
import br.com.lodi.samplespringamqp.domain.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonConsumer {

    @RabbitListener(queues = QueueConfig.MOVIE_QUEUE_NAME)
    public void consumeFromFirstQueue(final Movie movie) {
        log.info("Movie Queue - Message consumed={}", movie);
    }


}
