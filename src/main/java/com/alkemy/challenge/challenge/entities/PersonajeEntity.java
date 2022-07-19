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
@Table(name="personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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
    @Column
    private boolean deleted = Boolean.FALSE;


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
