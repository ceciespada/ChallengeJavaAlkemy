package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private LocalDate fecha;
    @Column
    private float calificacion;

    @ManyToMany(
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id"))
    private Set<PersonajeEntity> personajesSet = new HashSet<>();

    @ManyToMany(
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "genero_pelicula",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="genero_id"))
    private Set<GeneroEntity> generoSet = new HashSet<>();




}
