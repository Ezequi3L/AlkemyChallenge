package com.disney.challenge.pelicula;

import com.disney.challenge.personaje.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    public void addNewPelicula(Pelicula pelicula) {
        Optional<Pelicula> peliculaAux = peliculaRepository.findPeliculaByTitulo(pelicula.getTitulo());
        if (peliculaAux.isPresent()){
            throw new IllegalStateException("Ya hay una pelicula con este nombre");
        }
        peliculaRepository.save(pelicula);
    }

    public void updatePelicula(Long peliculaId, Pelicula pelicula) {
        Pelicula peliculaAux = peliculaRepository.findById(peliculaId).orElseThrow(()-> new IllegalStateException("La pelicula con el id " + peliculaId +" no existe"));
        peliculaAux.setTitulo(pelicula.getTitulo());
        peliculaAux.setFdc(pelicula.getFdc());
        peliculaAux.setCalificacion(pelicula.getCalificacion());
        peliculaRepository.save(peliculaAux);
    }

    public void deletePelicula(Long peliculaId) {
        boolean exists = (peliculaRepository.existsById(peliculaId));
        if (!exists){
            throw new IllegalStateException("La Pelicula con id " + peliculaId + " no existe");
        }
        peliculaRepository.deleteById(peliculaId);
    }
}