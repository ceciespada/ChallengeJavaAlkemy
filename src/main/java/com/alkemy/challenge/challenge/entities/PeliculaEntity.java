package com.alkemy.challenge.challenge.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="peliculas")
@Getter
@Setter
@SQLDelete(sql = "UPDATE peliculas SET deleted = true WHERE id_pelicula=?")
@Where(clause = "deleted=false")
public class PeliculaEntity {
    @Id
    @SequenceGenerator(name="peliculas_sequence",sequenceName = "peliculas_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "peliculas_sequence")
    @Column(name="id_pelicula")
    private Long idPelicula;
    @Column
    private String imagen;
    @Column
    private String titulo;
    @Column
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private LocalDate fecha;
    @Column
    @Max(5)
    @Min(1)
    private Integer calificacion;
    @Column
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name="peliculas_idPelicula"),
            inverseJoinColumns = @JoinColumn(name="personajes_idPersonaje"))
    private Set<PersonajeEntity> personajesSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "peliculas_generos",
            joinColumns = @JoinColumn(name="peliculas_idPelicula"),
            inverseJoinColumns = @JoinColumn(name="generos_idGenero"))
    private Set<GeneroEntity> generosSet = new HashSet<>();

    public PeliculaEntity() {
    }

    public PeliculaEntity(String imagen, String titulo, LocalDate fecha, Integer calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }
}
