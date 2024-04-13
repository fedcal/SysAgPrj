package com.enciclopedia;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@OpenAPIDefinition(
		info = @Info(
				title = "Applicativo robot medici: MS Enciclopedia",
				version = "1.0.0",
				description = "Microservizio dedicato alla gestione dell'enciclopedia medica contenente informazioni " +
						"relative a medicinali, malattie e sintomi.",
				contact = @Contact(
						name = "Federico Calò (matricola 678191)",
						email = "f.calo29@studenti.uniba.it",
						url = "https://www.federicocalo.dev"
				)
		),
		servers = {
				@Server(
						description = "Ambiente locale",
						url = "http://localhost:8080"
				)
		}
)
public class EnciclopediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnciclopediaApplication.class, args);
	}

}
