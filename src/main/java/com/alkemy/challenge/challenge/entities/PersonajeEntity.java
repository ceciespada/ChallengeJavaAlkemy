package com.alkemy.challenge.challenge.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToMany(fetch = FetchType.EAGER,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "personajesSet")
    @JsonIgnore
    private Set<PeliculaEntity> peliculasSet = new HashSet<>();


    public PersonajeEntity() {
    }
}
