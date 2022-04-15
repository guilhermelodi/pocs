package br.com.lodi.functionalandreactive.producer;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Component
public class NewUserProducer {

    private static final Faker faker = new Faker();

//    @Bean
//    public Function<String, String> sendNewUser() {
//        return newUser -> {
//            newUser = faker.dragonBall().character();
//            log.info("newUser produced: {}", newUser);
//
//            return newUser;
//        };
//    }

    @Bean
    public Supplier<String> sendNewUser() {
        return () -> {
            // select ativos sem sync
            // filter date
            final String newUser = faker.dragonBall().character();
            log.info("newUser produced: {}", newUser);

            return newUser;
        };
    }

}
