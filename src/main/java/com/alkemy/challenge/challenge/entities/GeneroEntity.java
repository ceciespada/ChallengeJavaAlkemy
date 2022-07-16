package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genero")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String imagen;

   /* private PeliculaEntity pelicula;

  @ManyToMany(mappedBy = "genero",cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculasList = new ArrayList<>();

    public void addPelicula(PeliculaEntity pelicula){
        this.peliculasList.add(pelicula);

    }

    public void removePelicula(PeliculaEntity pelicula){
        this.peliculasList.remove(pelicula);
    }*/









}
