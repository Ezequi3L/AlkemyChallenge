package com.disney.challenge.personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    Optional<Personaje> findPersonajeByNombre(String nombre);

/*    @Query("SELECT id,nombre FROM Personaje")
    List<Personaje> getPersonajesNombres();*/

}
