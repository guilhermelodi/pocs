package br.com.lodi.customer.processor;

import br.com.lodi.customer.channel.CustomerChannel;
import br.com.lodi.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerProcessor {

    @StreamListener(CustomerChannel.CUSTOMER_INPUT)
    @SendTo(CustomerChannel.VIP_CUSTOMER_OUTPUT)
    public KStream<String, Customer> process(KStream<String, Customer> customers) {
        return customers
                .filter((key, value) -> value.getMoneySpentPerMonth().doubleValue() > 1000);
    }

}
