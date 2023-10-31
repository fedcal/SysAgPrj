package com.robotmedico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RobotmedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotmedicoApplication.class, args);
	}

}
