package br.com.lodi.customer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomerChannel {

    String CUSTOMER_INPUT = "customer-input";

    @Input(CUSTOMER_INPUT)
    SubscribableChannel input();

}
