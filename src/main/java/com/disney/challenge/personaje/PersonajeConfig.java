package com.disney.challenge.personaje;

import com.disney.challenge.genero.Genero;
import com.disney.challenge.pelicula.Pelicula;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonajeConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonajeRepository repository){
        return args -> {
            Personaje personaje1 = new Personaje("personaje1",18,20F,"");
            Personaje personaje2 = new Personaje("personaje2",18,20F,"");
            repository.saveAll(List.of(personaje1,personaje2));

//            Pelicula pelicula = new Pelicula("", LocalDate.of(2021,1,1),0F);
//
//            pelicula.getPersonajes().add(new Personaje("personaje2",18,20F,""));
//
//            repository.save(pelicula);
//
//            Genero genero = new Genero("d");
//
//            repository.save(genero);

        };

    }
}
