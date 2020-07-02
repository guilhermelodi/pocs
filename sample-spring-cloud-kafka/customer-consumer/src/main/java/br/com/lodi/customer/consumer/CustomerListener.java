package br.com.lodi.customer.consumer;

import br.com.lodi.customer.channel.CustomerChannel;
import br.com.lodi.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerListener {

    @StreamListener(CustomerChannel.CUSTOMER_INPUT)
    public void receive(Customer customer) {
        log.info("Customer received: {}", customer);
    }

}
