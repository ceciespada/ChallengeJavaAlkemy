package com.alkemy.challenge.challenge.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Integer edad;
    @Column
    private Float peso;
    @Column
    private String historia;

  /*  @ManyToMany(mappedBy="personaje")
    private Set<PeliculaEntity> peliculasSet = new HashSet<>();


    public void addPelicula(PeliculaEntity pelicula){
        this.peliculasList.add(pelicula);

    }

    public void removePelicula(PeliculaEntity pelicula){
        this.peliculasList.remove(pelicula);
    }

     */

}
