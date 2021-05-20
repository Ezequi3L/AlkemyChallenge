package com.disney.challenge.personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/characters")
public class PersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping
    public List<Personaje> getPersonajes() {
        return personajeService.getPersonajes() ;
    }

    @PostMapping
    public void registerNewCharacter(@RequestBody Personaje personaje){
        personajeService.addNewPersonaje(personaje);
    }

    @PutMapping(path = "{personajeId}")
    public void updatePersonaje(@RequestBody Personaje personaje, @PathVariable("personajeId") Long personajeId){
        personajeService.updatePersonaje(personajeId, personaje);
    }

    @DeleteMapping(path = "{personajeId}")
    public void deletePersonaje(@PathVariable("personajeId") Long personajeId){
        personajeService.deletePersonaje(personajeId);

    }
}
