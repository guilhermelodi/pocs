package br.com.lodi.samplespringamqp.controller;

import br.com.lodi.samplespringamqp.config.TopicExchangeConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "topic")
public class TopicController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/{routingKey:.+}")
    public HttpEntity<?> sendTopic(@PathVariable final String routingKey, @RequestBody final String message) {
        log.info("sendTopic, routingKey={}, message={}", routingKey, message);

        rabbitTemplate.convertAndSend(TopicExchangeConfig.NAME, routingKey, message);

        return ResponseEntity.ok().build();
    }

}
