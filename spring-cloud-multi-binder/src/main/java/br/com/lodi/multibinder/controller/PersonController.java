package br.com.lodi.multibinder.controller;

import br.com.lodi.multibinder.channel.PersonCreatedChannel;
import br.com.lodi.multibinder.domain.Person;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonCreatedChannel personCreatedChannel;

    @GetMapping(value = "/send")
    @ResponseStatus(HttpStatus.OK)
    public void send() {
        final Faker faker = new Faker();

        final Person person = Person.builder()
            .id(faker.number().randomNumber())
            .name(faker.funnyName().name())
            .employee(faker.bool().bool())
            .build();

        final Message<Person> message = MessageBuilder.withPayload(person).build();
        personCreatedChannel.output().send(message);
    }
}