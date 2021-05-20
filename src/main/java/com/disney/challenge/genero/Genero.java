package com.disney.challenge.genero;

import javax.persistence.*;

@Entity
@Table (name="generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "generoID")
    private Long id;

    private String nombre;

    public Genero() {
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
