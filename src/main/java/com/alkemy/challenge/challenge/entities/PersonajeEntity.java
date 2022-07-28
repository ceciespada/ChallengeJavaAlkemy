package com.alkemy.challenge.challenge.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personajes")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personajes SET deleted = true WHERE id_personaje=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {

    @Id
    @SequenceGenerator(name="personajes_sequence",sequenceName = "personajes_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "personajes_sequence")
    @Column(name="id_personaje")
    private Long idPersonaje;
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
    @Column
    private boolean deleted = Boolean.FALSE;


    @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "personajesSet")
    @JsonIgnore
    private Set<PeliculaEntity> peliculasSet = new HashSet<>();


    public PersonajeEntity() {
    }

    public PersonajeEntity(String imagen, String nombre, Integer edad, Float peso, String historia, boolean deleted, Set<PeliculaEntity> peliculasSet) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.deleted = deleted;
        this.peliculasSet = peliculasSet;
    }

    public void agregarPelicula(PeliculaEntity peliculaEntity){
        peliculasSet.add(peliculaEntity);
    }

    public void eliminarPelicula(PeliculaEntity peliculaEntity){
        peliculasSet.remove(peliculaEntity);
    }

}
