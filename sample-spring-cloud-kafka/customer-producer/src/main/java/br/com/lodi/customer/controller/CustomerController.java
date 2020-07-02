package br.com.lodi.customer.controller;

import br.com.lodi.customer.domain.Customer;
import br.com.lodi.customer.producer.CustomerProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CustomerController {

    final CustomerProducer customerProducer;

    public CustomerController(CustomerProducer customerProducer) {
        this.customerProducer = customerProducer;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Customer customer) {
        log.info("Request to create customer={}", customer);

        customerProducer.produce(customer);

        log.info("Sent to kafka");
    }
}
