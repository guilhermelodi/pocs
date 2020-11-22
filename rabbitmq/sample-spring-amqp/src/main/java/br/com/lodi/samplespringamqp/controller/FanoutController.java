package br.com.lodi.samplespringamqp.controller;

import br.com.lodi.samplespringamqp.config.FanoutExchangeConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "fanout")
public class FanoutController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public HttpEntity<?> sendFanout(@RequestBody final String message) {
        log.info("sendFanout, message={}",  message);

        rabbitTemplate.convertAndSend(FanoutExchangeConfig.NAME, "", message);

        return ResponseEntity.ok().build();
    }

}
