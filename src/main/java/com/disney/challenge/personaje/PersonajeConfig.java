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
            Personaje ezequiel = new Personaje("ezequiel",22,87F,"autista");
            Personaje viejo = new Personaje("viejo",22,87F,"autista");
            Personaje yamato = new Personaje("yamato",22,87F,"autista");
            Personaje chaca = new Personaje("chaca",22,200F,"autista");

            repository.saveAll(List.of(ezequiel,viejo,yamato,chaca));

        };

    }
}
