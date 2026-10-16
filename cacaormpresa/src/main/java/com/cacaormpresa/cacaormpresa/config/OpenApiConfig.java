package com.cacaormpresa.cacaormpresa.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("API Intranet Agroindustrial - Cacao Premium del Perú S.A.C.")
                        .description("Backend REST API para la gestión de producción de cacao fino de aroma: acopio en baba, " +
                                "trazabilidad de fermentación, control de secado, pesaje por secciones (granos y polvo), " +
                                "balance integral de masas, pedidos de exportación y packing list marítimo.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo - Cacao Premium")
                                .email("contacto@cacaopremium.pe"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
