package br.com.lodi.functionalandreactive.resource;

import br.com.lodi.functionalandreactive.producer.NewUserProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserResource {

    private final NewUserProducer producer;

    @GetMapping
    public void sendNewUser() {
        log.info("Request received");
        producer.sendNewUser().get();
        log.info("Request finished");
    }

}
