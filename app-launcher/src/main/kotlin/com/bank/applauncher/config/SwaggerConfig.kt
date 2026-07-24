package com.bank.applauncher.config

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
class SwaggerConfig {

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Bank Backend 'FreeBank'")
                    .version("1.0")
                    .description("Документація для backend 'FreeBank'")
            )
    }

    @Bean
    fun userServiceApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("user-service")
            .pathsToMatch("/api/v1/users/**")
            .packagesToScan("com.bank.userservice.web.controllers")
            .build()
    }
}