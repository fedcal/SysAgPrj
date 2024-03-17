package com.msmedico;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Applicativo robot medici: Ms-medico",
				version = "1.0.0",
				description = "Strato applicativo tramite il quale si espongono al bff tutti quei path e controller dedicati " +
						"al recupero di informazioni di medici. Inoltre attraverso questo microservizio i medici possono " +
						"scambiare messaggi con i pazienti e gli infermieri, oltre a prescrivere medicinali e a visitare i pazienti.",
				contact = @Contact(
						name = "Federico Calò (matricola 678191)",
						email = "f.calo29@studenti.uniba.it",
						url = "https://www.federicocalo.dev"
				)
		),
		servers = {
				@Server(
						description = "Ambiente locale",
						url = "http://localhost:8081"
				)
		}
)
public class MsMedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMedicoApplication.class, args);
	}

}
