package com.challenge.apidisney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<Parameter> commonParameters = new ArrayList<>();
        commonParameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("Token para acceder a la API")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters(commonParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.challenge.apidisney.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API - DISNEY (CHALLENGE ALKEMY)",
                "API para explorar el mundo de Disney, la cual permitirá conocer y modificar los\n" +
                        "personajes que lo componen y entender en qué películas estos participaron.",
                "v1.0.0",
                "Terminos y condiciones",
                new Contact("Juan Escurra", "https://github.com/JuanEscurra", "j.escurra.1999@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
