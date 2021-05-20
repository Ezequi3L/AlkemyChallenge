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

   /* public List<Personaje> getPersonajesNombres() {
        return personajeRepository.getPersonajesNombres();
    }*/

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

    public void updatePersonaje(Long personajeId, Personaje personaje) {
        Personaje personajeAux = personajeRepository.findById(personajeId).orElseThrow(()-> new IllegalStateException("El personaje con el id " + personajeId +" no existe"));
        personajeAux.setNombre(personaje.getNombre());
        personajeAux.setEdad(personaje.getEdad());
        personajeAux.setPeso(personaje.getPeso());
        personajeAux.setHistoria(personaje.getHistoria());
        personajeRepository.save(personajeAux);


    }

    public void deletePersonaje(Long personajeId) {
        boolean exists = (personajeRepository.existsById(personajeId));
        if (!exists){
            throw new IllegalStateException("El personaje con id " + personajeId + " no existe");
        }
        personajeRepository.deleteById(personajeId);
    }

}
