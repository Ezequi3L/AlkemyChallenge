package com.disney.challenge.pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}