package br.com.lodi.customer.consumer;

import br.com.lodi.customer.channel.VIPCustomerChannel;
import br.com.lodi.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VIPCustomerListener {

    @StreamListener(VIPCustomerChannel.VIP_CUSTOMER_INPUT)
    public void receive(Customer customer) {
        log.info("VIP Customer registered: " + customer);
    }

}
