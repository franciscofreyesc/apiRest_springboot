package com.init.products.productapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        //Todos los metodos que va a buscar para documentar, en este caso buscará por paquete
        //la opcion .any() busca en todo el código
        .apis(RequestHandlerSelectors.basePackage("com.init.products.productapi.rest"))
        //Como ya encontó todo arriba, ahora buscará todos los paths
        .paths(PathSelectors.any())
        //Construir la documentación
        .build();

    }
}