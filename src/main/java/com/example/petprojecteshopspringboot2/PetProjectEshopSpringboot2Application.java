package com.example.petprojecteshopspringboot2;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.example.petprojecteshopspringboot2")

public class PetProjectEshopSpringboot2Application {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        ConfigurableApplicationContext context =
                SpringApplication.run(PetProjectEshopSpringboot2Application.class, args);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        String encodedPassword = encoder.encode("pass");
        System.out.println("Encoded password: " + encodedPassword);

        System.out.println("Does the password match? " + encoder.matches
                ("pass", encodedPassword));
    }
}
