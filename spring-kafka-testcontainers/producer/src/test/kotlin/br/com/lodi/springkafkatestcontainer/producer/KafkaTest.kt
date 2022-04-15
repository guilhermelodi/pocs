package br.com.lodi.springkafkatestcontainer.producer

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.context.EmbeddedKafka
import org.testcontainers.containers.KafkaContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@Testcontainers
class KafkaTest {

    @Autowired
    private lateinit var producer: Producer

    companion object {
        lateinit var kafkaContainer: KafkaContainer

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            kafkaContainer = KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"))
            kafkaContainer.start()
        }
    }

    @Test
    fun test() {

        producer.produce("max_3")

    }

}