package com.hexagonal.supermarket.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Supermarket Hexagonal Architecture API",
                version = "1.0.0",
                description = "Documentacion de la API de Supermarket Hexagonal Architecture y DDD"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8085",
                        description = "Servidor de desarrollo local"
                )
        }
)
public class OpenApiConfig {
}
