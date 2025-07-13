package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        System.out.println("Spring Boot application started successfully! 🎉");
        SpringApplication.run(SpringLearnApplication.class, args);
    }
}
