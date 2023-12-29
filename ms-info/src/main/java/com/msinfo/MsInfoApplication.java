package com.msinfo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Applicativo robot medici: Ms-info",
                version = "1.0.0",
                description = "Strato applicativo tramite il quale si espongono al bff tutti quei path e controller dedicati " +
                        "al recupero di informazioni di medici, infermieri, specialisti e pazienti",
                contact = @Contact(
                        name = "Federico Calò",
                        email = "f.calo29@studenti.uniba.it",
                        url = "https://www.federicocalo.dev"
                )
        ),
        servers = {
                @Server(
                        description = "Ambiente locale",
                        url = "http://localhost:8086"
                )
        }
)
public class MsInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsInfoApplication.class, args);
    }

}
