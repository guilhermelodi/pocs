package br.com.lodi.multibinder.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PersonCreatedChannel {

    String OUTPUT = "person-created-output";
    String INPUT = "person-created-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();


}
