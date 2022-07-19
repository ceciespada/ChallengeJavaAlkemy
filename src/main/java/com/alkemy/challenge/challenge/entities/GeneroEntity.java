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
@Table(name="genero")
@Getter
@Setter
@SQLDelete(sql = "UPDATE genero SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String imagen;
    @Column
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "generosSet")
    @JsonIgnore
    private Set<PeliculaEntity> peliculasSet = new HashSet<>();

    public GeneroEntity() {
    }
}
