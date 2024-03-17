package com.msinfermiere;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Applicativo robot medici: Ms-infermiere",
				version = "1.0.0",
				description = "Strato applicativo tramite il quale si espongono al bff tutti quei path e controller dedicati " +
						"al recupero di informazioni di infermieri. Gli infermieri con questo microservizio possono entrare in cotatto con " +
						"i pazienti e i medici. Inoltre possono somministrare visite e medicinali ai pazienti.",
				contact = @Contact(
						name = "Federico Calò (matricola 678191)",
						email = "f.calo29@studenti.uniba.it",
						url = "https://www.federicocalo.dev"
				)
		),
		servers = {
				@Server(
						description = "Ambiente locale",
						url = "http://localhost:8082"
				)
		}
)
public class MsinfermiereApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsinfermiereApplication.class, args);
	}

}
