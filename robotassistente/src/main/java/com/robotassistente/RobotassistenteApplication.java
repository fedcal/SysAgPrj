package com.robotassistente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RobotassistenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotassistenteApplication.class, args);
	}

}
