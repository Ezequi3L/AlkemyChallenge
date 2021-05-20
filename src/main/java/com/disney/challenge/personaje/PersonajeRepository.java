package com.disney.challenge.personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    Optional<Personaje> findPersonajeByNombre(String nombre);

}
