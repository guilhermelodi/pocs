package br.com.lodi.multibinder;

import br.com.lodi.multibinder.channel.NotifyRegistrationDepartamentChannel;
import br.com.lodi.multibinder.channel.PersonCreatedChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({
	PersonCreatedChannel.class,
	NotifyRegistrationDepartamentChannel.class
})
@SpringBootApplication
public class SpringCloudMultiBinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMultiBinderApplication.class, args);
	}

}
