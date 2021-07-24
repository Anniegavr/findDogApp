package com.learn.devme.postgres;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DogConfig {
    @Bean
    CommandLineRunner dogCommandLineRunner(DogRepository repository){
        return args -> {
            Dog Husky = new Dog("Husky");
            Dog Wolf = new Dog("Wolf");
            repository.saveAll(List.of(Husky, Wolf));
        };

    }
}
