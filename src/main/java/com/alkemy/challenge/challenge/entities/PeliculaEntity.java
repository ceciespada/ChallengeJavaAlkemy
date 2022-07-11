package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String imagen;
    @Column
    private String titulo;
    @Column
    private LocalDate fecha;
    @Column
    private float calificacion;
    @JoinColumn
    private List<PersonajeEntity> personajes;
    @JoinColumn
    private List<GeneroEntity> generos;


}
