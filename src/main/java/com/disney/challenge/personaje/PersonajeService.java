package com.disney.challenge.personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<Personaje> getPersonajes() {
        return personajeRepository.findAll();
    }

    public void addNewPersonaje(Personaje personaje) {
        Optional<Personaje> personajeAux = personajeRepository.findPersonajeByNombre(personaje.getNombre());
        if (personajeAux.isPresent()){
            throw new IllegalStateException("Ya hay un personaje con este nombre");
        }
        personajeRepository.save(personaje);

    }
}
