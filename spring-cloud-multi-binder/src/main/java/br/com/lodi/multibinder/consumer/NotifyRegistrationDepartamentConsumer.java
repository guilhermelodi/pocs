package br.com.lodi.multibinder.consumer;

import br.com.lodi.multibinder.channel.NotifyRegistrationDepartamentChannel;
import br.com.lodi.multibinder.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotifyRegistrationDepartamentConsumer {

    @StreamListener(NotifyRegistrationDepartamentChannel.INPUT)
    public void consumeNotify(final Person person) {
        log.info("M=consumeNotify, person={}", person);

        //throw new IllegalArgumentException("Testando o envio para a DLQ");
    }

}
