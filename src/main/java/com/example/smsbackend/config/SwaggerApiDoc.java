package com.example.smsbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.*;

@Configuration
public class SwaggerApiDoc {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            Arrays.asList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(appInfo())
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.smsbackend.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }


    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }


    private ApiInfo appInfo() {
        return new ApiInfo(
                "Shop24 documentation",
                "Shop24 is a soft drinks wholesaler based in Kigali. They would like to avail their services to public by providing a white-label solution to the\n" +
                        "existing retailer companies/hotels. Practically, they will build a set of APIs that hotels will use to manage their requests of buying from\n" +
                        "Shop24 and transport to their clients. They would like your help building these APIs and document them using swagger",
                "1.0.0",
                "https://github.com/dmutoni/shop24",
                new Contact("SHOP 24 Project", "https://shop.rw/", "shop@gmail.com"),
                "MIT",
                "https://github.com/dmutoni/shop24/blob/main/LICENSE",
                Collections.emptyList()
        );
    }
}