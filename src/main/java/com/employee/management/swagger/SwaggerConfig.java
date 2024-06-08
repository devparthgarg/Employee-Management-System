package com.employee.management.swagger;

import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi healthControllerAPI() {
        String[] paths = {"/health"};
        return GroupedOpenApi.builder().group("Health API").pathsToMatch(paths).build();
    }

    @Bean
    public GroupedOpenApi employeeControllerAPI() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder().group("Employee APIs").pathsToMatch(paths).addOperationCustomizer(customizer()).build();
    }

    private OperationCustomizer customizer() {
        return (operation, handlerMethod) -> operation.addParametersItem(new Parameter().in("header")
                .required(true).description("Authorized token").name("x-api-token"));
    }
}
