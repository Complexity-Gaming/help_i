package com.complexity.gaming.help_i.shared.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class OpenApiConfiguration {
    @Bean(name = "HelpIOpenApi")
    public OpenAPI bloggingOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Help-I application API")
                        .description("Help-I API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));
    }

}