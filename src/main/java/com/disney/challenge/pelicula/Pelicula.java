package com.disney.challenge.pelicula;

import com.disney.challenge.genero.Genero;
import com.disney.challenge.personaje.Personaje;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaID")
    private Long id;

    private String titulo;
    private LocalDate fdc;
    private Float calificacion;

    @JoinTable(name="rel_pel_pers"
            ,joinColumns=@JoinColumn(name="peliculaID")
            ,inverseJoinColumns=@JoinColumn(name="personajeID")
    )
    @ManyToMany
    private Set<Personaje> personajes;

    @ManyToOne
    @JoinColumn(name = "pel_genero")
    Genero genero;

    public Pelicula() {
    }

    public Pelicula(String titulo, LocalDate fdc, Float calificacion) {
        this.titulo = titulo;
        this.fdc = fdc;
        this.calificacion = calificacion;
    }

    public Pelicula(Long id, String titulo, LocalDate fdc, Float calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.fdc = fdc;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFdc() {
        return fdc;
    }

    public void setFdc(LocalDate fdc) {
        this.fdc = fdc;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Set<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Set<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void addPersonaje(Personaje personaje){
        if (this.personajes == null){
            this.personajes = new HashSet<>();
        }
        this.personajes.add(personaje);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fdc=" + fdc +
                ", calificacion=" + calificacion +
                '}';
    }
}
