package br.com.lodi.multibinder.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface NotifyRegistrationDepartamentChannel {

    String OUTPUT = "notify-registration-departament-output";
    String INPUT = "notify-registration-departament-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();

}
