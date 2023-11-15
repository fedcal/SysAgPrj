package com.enciclopedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EnciclopediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnciclopediaApplication.class, args);
	}

}
