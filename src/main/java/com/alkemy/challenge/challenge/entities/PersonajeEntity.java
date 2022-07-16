package com.alkemy.challenge.challenge.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String imagen;
    @Column
    private String nombre;
    @Column
    private int edad;
    @Column
    private float peso;
    @Column
    private String historia;
    @ManyToMany(mappedBy = "personaje",cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculasList = new ArrayList<>();

    public void addPelicula(PeliculaEntity pelicula){
        this.peliculasList.add(pelicula);

    }

    public void removePelicula(PeliculaEntity pelicula){
        this.peliculasList.remove(pelicula);
    }











}
