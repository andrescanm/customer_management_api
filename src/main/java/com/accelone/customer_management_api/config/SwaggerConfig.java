package com.accelone.customer_management_api.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customerManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Customer Management API")
                        .description("API for managing customers")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Customer Management Wiki Documentation")
                        .url("https://github.com/yourrepo/yourproject/wiki"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("customer-management")
                .pathsToMatch("/customers/**")
                .build();
    }
}
