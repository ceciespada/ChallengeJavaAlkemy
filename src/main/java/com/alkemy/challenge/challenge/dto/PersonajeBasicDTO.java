package com.alkemy.challenge.challenge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeBasicDTO {

    private Long idPersonaje;

    private String imagen;

    private String nombre;

    private Integer edad;

    private Float peso;

    private String historia;
}
