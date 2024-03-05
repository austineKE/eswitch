package com.tech.eswitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.tech.eswitch.repo")
@SpringBootApplication
public class EswitchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EswitchApplication.class, args);
	}

}
