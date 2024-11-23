package com.example.demo;

//SERGIO ANTONIO GOMEZ CAZARES//
//BRYAN TADEO ZAVALA MARTINEZ//
//JOHAN URIEL CARRILLO PORTILLO//
//CARLOS ALBERTO ROMERO CORRAL//
//JESUS ARTUTO CARRILLO AVILEZ

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
