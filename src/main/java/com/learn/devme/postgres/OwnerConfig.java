package com.learn.devme.postgres;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OwnerConfig {

    @Bean
    CommandLineRunner commandLineRunner(OwnerRepository repository){
        return args -> {
            Owner Ana = new Owner("Ana", "123");
            Owner Anastasia = new Owner("Anastasia", "1234");
            repository.saveAll(List.of(Ana, Anastasia));
        };

    }



}
