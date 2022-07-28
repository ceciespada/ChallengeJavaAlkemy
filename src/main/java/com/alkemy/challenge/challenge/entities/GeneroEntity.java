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
@Table(name="generos")
@Getter
@Setter
@SQLDelete(sql = "UPDATE generos SET deleted = true WHERE id_genero=?")
@Where(clause = "deleted=false")
public class GeneroEntity {
    @Id
    @SequenceGenerator(name="generos_sequence",sequenceName = "generos_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generos_sequence")
    @Column(name="id_genero")
    private Long idGenero;
    @Column
    private String nombre;
    @Column
    private String imagen;
    @Column
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "generosSet")
    @JsonIgnore
    private Set<PeliculaEntity> peliculasSet = new HashSet<>();

    public GeneroEntity() {
    }

    public GeneroEntity(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public GeneroEntity(String nombre, String imagen, boolean deleted, Set<PeliculaEntity> peliculasSet) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.deleted = deleted;
        this.peliculasSet = peliculasSet;
    }

    public void agregarPelicula(PeliculaEntity peliculaEntity){
        peliculasSet.add(peliculaEntity);
    }

    public void eliminarPelicula(PeliculaEntity peliculaEntity){
        peliculasSet.remove(peliculaEntity);
    }

    public Set<PeliculaEntity> getPeliculasSet() {
        return peliculasSet;
    }

    public void setPeliculasSet(Set<PeliculaEntity> peliculasSet) {
        this.peliculasSet = peliculasSet;
    }
}
