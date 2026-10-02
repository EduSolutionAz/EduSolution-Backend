package com.edu.edusolution.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public static final String BEARER_AUTH_SCHEME = "bearerAuth";

    @Bean
    public OpenAPI edusolutionOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ES Academy API")
                        .version("v1")
                        .description("API documentation for the ES Academy platform."))
                .components(new Components()
                        .addSecuritySchemes(BEARER_AUTH_SCHEME, new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Paste the token returned by the login endpoint. "
                                        + "The value is sent as 'Authorization: Bearer <token>' automatically.")));
    }
}
