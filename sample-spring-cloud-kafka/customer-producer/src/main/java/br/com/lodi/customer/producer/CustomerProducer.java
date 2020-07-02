package br.com.lodi.customer.producer;

import br.com.lodi.customer.channel.CustomerChannel;
import br.com.lodi.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerProducer {

    private final CustomerChannel customerChannel;

    public CustomerProducer(CustomerChannel customerChannel) {
        this.customerChannel = customerChannel;
    }

    public void produce(final Customer customer) {
        final Message<Customer> message = MessageBuilder
                .withPayload(customer)
                .build();

        customerChannel.output().send(message);
    }
}
