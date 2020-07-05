package br.com.lodi.customer.channel;

import br.com.lodi.customer.domain.Customer;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.apache.kafka.streams.kstream.KStream;

public interface CustomerChannel {

    String CUSTOMER_INPUT = "customer-input";
    String VIP_CUSTOMER_OUTPUT = "vip-customer-output";

    @Input(CUSTOMER_INPUT)
    KStream<String, Customer> input();

    @Output(VIP_CUSTOMER_OUTPUT)
    KStream<String, Customer> output();
}
