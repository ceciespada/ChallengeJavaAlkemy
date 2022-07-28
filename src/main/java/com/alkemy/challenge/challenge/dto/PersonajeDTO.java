package com.alkemy.challenge.challenge.dto;


import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;


@Getter
@Setter
public class PersonajeDTO {

    private Long idPersonaje;

    private String imagen;

    private String nombre;

    private Integer edad;

    private Float peso;

    private String historia;

    private Set<PeliculaEntity> peliculaEntitySet;

    public void agregarPelicula(PeliculaEntity peliculaEntity){
        peliculaEntitySet.add(peliculaEntity);
    }

    public void eliminarPelicula(PeliculaEntity peliculaEntity){
        peliculaEntitySet.remove(peliculaEntity);
    }
}
