package br.com.lodi.samplespringamqp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "basic")
public class BasicRabbitController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public HttpEntity<?> sendHelloWorld() {
        log.info("enviando Hello World");

        rabbitTemplate.convertAndSend("first-queue", "Hello World");

        return ResponseEntity.ok().build();
    }

}
