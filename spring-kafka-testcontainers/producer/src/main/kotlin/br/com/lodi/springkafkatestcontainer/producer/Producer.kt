package br.com.lodi.springkafkatestcontainer.producer

import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class Producer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun produce(value: String) {
        log.info("Starting produce, value=$value")

        val record = ProducerRecord(TOPIC, "poc", value)
        kafkaTemplate.send(record)

        log.info("Produce finished, value=$value")
    }

    companion object {
        const val TOPIC = "poc.test.kafka"
    }

}