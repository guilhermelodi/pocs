package br.com.lodi.customer.config;

import br.com.lodi.customer.channel.CustomerChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CustomerChannel.class)
public class StreamsConfig {
}
