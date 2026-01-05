package br.com.coti.api_clientes.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    /**
     * Politica de CORS no SpringBoot para autorizar
     * o projeto Angular (http://localhost:4200)
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Libera todos os endpoints da API
                        .allowedOrigins("http://localhost:4200") // Origem do seu Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Permite todos os cabeçalhos (headers)
                        .allowCredentials(true); // Permite envio de cookies ou autenticação, se necessário
            }
        };
    }
}