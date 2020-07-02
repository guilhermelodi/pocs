package br.com.lodi.customer.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerChannel {

    String CUSTOMER_OUTPUT = "prompt-delivery-exchange-order-created-output";

    @Output(CUSTOMER_OUTPUT)
    MessageChannel output();

}
