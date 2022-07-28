package com.alkemy.challenge.challenge.dto;

import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class GeneroDTO {

    private Long idGenero;

    private String nombre;

    private String imagen;

    private Set<PeliculaEntity> peliculaEntitySet;

    public void agregarPelicula(PeliculaEntity peliculaEntity){peliculaEntitySet.add(peliculaEntity);}

    public void eliminarPelicula(PeliculaEntity peliculaEntity){
       peliculaEntitySet.remove(peliculaEntity);
    }
}
