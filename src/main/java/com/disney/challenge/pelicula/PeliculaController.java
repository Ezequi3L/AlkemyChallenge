package com.disney.challenge.pelicula;

import com.disney.challenge.personaje.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movies")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @PostMapping
    public void registerNewPelicula(@RequestBody Pelicula pelicula){
        peliculaService.addNewPelicula(pelicula);
    }

    @PutMapping(path = "{peliculaId}")
    public void updatePelicula(@RequestBody Pelicula pelicula, @PathVariable("peliculaId") Long peliculaId){
        peliculaService.updatePelicula(peliculaId, pelicula);
    }

    @DeleteMapping(path = "{peliculaId}")
    public void deletePelicula(@PathVariable("peliculaId") Long peliculaId){
        peliculaService.deletePelicula(peliculaId);

    }

}