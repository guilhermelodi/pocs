package br.com.lodi.springkafkatestcontainer.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {

    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["poc.test.kafka"])
    fun consume(message: String) =
        log.info("Consuming message, value=$message")


}