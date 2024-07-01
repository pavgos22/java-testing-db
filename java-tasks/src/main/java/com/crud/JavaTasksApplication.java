package com.crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition
@SpringBootApplication
@EnableScheduling
public class JavaTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTasksApplication.class, args);
    }

}
