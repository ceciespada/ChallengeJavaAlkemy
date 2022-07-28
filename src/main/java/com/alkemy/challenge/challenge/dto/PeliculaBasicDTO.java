package com.alkemy.challenge.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PeliculaBasicDTO {

    private Long idPelicula;

    private String imagen;

    private String titulo;

    private LocalDate fecha;

    private Integer calificacion;

}
