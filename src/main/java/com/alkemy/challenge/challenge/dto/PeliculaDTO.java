package com.alkemy.challenge.challenge.dto;

import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private Long idPelicula;

    private String imagen;

    private String titulo;

    private LocalDate fecha;

    private Integer calificacion;

    private Set<PersonajeEntity> personajeEntitySet;

    private Set<GeneroEntity> generoEntitySet;

    public PeliculaDTO() {
    }

    public void agregarPersonaje(PersonajeEntity personajeEntity){
        personajeEntitySet.add(personajeEntity);
    }

    public void eliminarPersonaje(PersonajeEntity personajeEntity){
        personajeEntitySet.remove(personajeEntity);
    }

    public void agregarGenero(GeneroEntity generoEntity){
        generoEntitySet.add(generoEntity);
    }

    public void eliminarGenero(GeneroEntity generoEntity){
        generoEntitySet.remove(generoEntity);
    }
}
