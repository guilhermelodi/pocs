package br.com.lodi.multibinder.consumer;

import br.com.lodi.multibinder.channel.NotifyRegistrationDepartamentChannel;
import br.com.lodi.multibinder.channel.PersonCreatedChannel;
import br.com.lodi.multibinder.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonCreatedConsumer {

    @StreamListener(PersonCreatedChannel.INPUT)
    @SendTo(NotifyRegistrationDepartamentChannel.OUTPUT)
    public Person consumePerson(final Person person) {
        log.info("M=consumePerson, person={}", person);

        return person.getEmployee() ? person : null;
    }


}
