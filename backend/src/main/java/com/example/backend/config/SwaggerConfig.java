package com.example.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Minha API")
                .version("1.0")
                .description("Documentação da API"))
            .servers(List.of(
                new Server().url("https://solid-spoon-75qp9xxvxq4fpp74-8080.app.github.dev")
            ));
    }
}
