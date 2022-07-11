package com.alkemy.challenge.challenge.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JoinColumn
    private List<PeliculaEntity> peliculas;









}
