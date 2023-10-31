package com.centromessaggistica.config;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.centromessaggistica.controller"))
                .paths(PathSelectors.ant( "/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CentroMessagistica API")
                .license("")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("","", ""))
                .build();
    }
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Centro Messaggistica API")
                        .termsOfService("")
                        .version("1.0.0")
                        .license(new License()
                                .name(""))
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .email("")));
    }
}
