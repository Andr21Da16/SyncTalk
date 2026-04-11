package com.andree.synctalk.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${dev.open-api.dev-url}")
    private String devOpenApiUrl;

    @Bean
    public OpenAPI openAPI() {
        Server devServer = new Server();
        devServer.setUrl(devOpenApiUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("johelandreevargasvillanueva07@gmail.com");
        contact.setName("Johel Andreé Vargas Villanueva");
        contact.setUrl("https://synctalk-production-35bf.up.railway.app/api/v1");

        License mitLicense = new License().name("MIT License")
                .url("https://choosealicense.com/license/mit/");

        Info info = new Info()
                .title("SyncTalk API")
                .version("1.0")
                .contact(contact)
                .description("This API expose endpoints")
                .termsOfService("https://www.hampcode.com/terms")
                .license(mitLicense);

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("JWT Authentication");

        Components components = new Components()
                .addSecuritySchemes("bearerAuth", securityScheme);

        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList("bearerAuth");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
