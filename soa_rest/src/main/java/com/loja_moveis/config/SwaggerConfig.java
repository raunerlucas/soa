package com.loja_moveis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI lojaMoveisOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Loja de Móveis")
                        .version("1.0.0")
                        .description("API para cadastro de produtos e móveis"));
    }

}