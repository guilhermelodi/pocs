package br.com.lodi.functionalandreactive.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class NewUserConsumer {

    @Bean
    public Consumer<String> receiveNewUser() {
        return newUser -> log.info("newUser consumed: {}", newUser);
    }

}
