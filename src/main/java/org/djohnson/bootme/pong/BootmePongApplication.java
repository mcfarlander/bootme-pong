package org.djohnson.bootme.pong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.djohnson.bootme.pong"})
public class BootmePongApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootmePongApplication.class, args);
	}

}
