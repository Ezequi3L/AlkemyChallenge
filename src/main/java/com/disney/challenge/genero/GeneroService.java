package com.disney.challenge.genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }
}