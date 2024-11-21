package com.example.demo;

//SERGIO ANTONIO GOMEZ CAZARES//
//Bryan Tadeo Zavala Martinez//
//JOHAN URIEL CARRILLO PORTILLO//
//Carlos Alberto Romero Corral//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model")

public class DemoApplication {
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(DemoApplication.class, args);
    }
}
