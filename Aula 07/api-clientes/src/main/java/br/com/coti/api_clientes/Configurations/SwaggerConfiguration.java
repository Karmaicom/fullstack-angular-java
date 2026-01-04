package br.com.coti.api_clientes.Configurations;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    /**
     * Metodo para configurar a
     * documentacao do swagger
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Clientes API - COTI Informatica")
                        .version("v1")
                        .description("API REST para gerenciamento de clientes")
                );
    }

}
