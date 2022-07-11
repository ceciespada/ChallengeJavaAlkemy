package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JoinColumn
    private List<PeliculaEntity> peliculas;






}
