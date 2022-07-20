package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="peliculas")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pelicula SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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
    private Float calificacion;
    @Column
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name="peliculas_id"),
            inverseJoinColumns = @JoinColumn(name="personajes_id"))
    private Set<PersonajeEntity> personajesSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "peliculas_generos",
            joinColumns = @JoinColumn(name="peliculas_id"),
            inverseJoinColumns = @JoinColumn(name="generos_id"))
    private Set<GeneroEntity> generosSet = new HashSet<>();

    public PeliculaEntity() {
    }

    public PeliculaEntity(String imagen, String titulo, LocalDate fecha, Float calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }
}
