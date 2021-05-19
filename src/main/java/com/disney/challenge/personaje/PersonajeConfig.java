package com.disney.challenge.personaje;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonajeConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonajeRepository repository){
        return args -> {
            Personaje personaje1 = new Personaje("personaje1",18,20F,"");
            Personaje personaje2 = new Personaje("personaje2",18,20F,"");

            repository.saveAll(List.of(personaje1,personaje2));

        };

    }
}
