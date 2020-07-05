package br.com.lodi.customer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface VIPCustomerChannel {

    String VIP_CUSTOMER_INPUT = "vip-customer-input";

    @Input(VIP_CUSTOMER_INPUT)
    SubscribableChannel input();
}
