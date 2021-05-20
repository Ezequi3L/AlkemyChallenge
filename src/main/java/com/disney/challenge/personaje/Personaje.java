package com.disney.challenge.personaje;

import com.disney.challenge.pelicula.Pelicula;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name="personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personajeID")
    private Long id;

    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;

    @ManyToMany(mappedBy = "personajes")
    private Set<Pelicula> peliculas;

    public Personaje() {
    }

    public Personaje(String nombre, Integer edad, Float peso, String historia) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Personaje(Long id, String nombre, Integer edad, Float peso, String historia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer age) {
        this.edad = age;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float weight) {
        this.peso = weight;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String history) {
        this.historia = history;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                '}';
    }
}
