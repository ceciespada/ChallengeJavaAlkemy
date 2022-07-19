package com.alkemy.challenge.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PeliculaDTO {

    private Long id;

    private String imagen;

    private String titulo;

    private LocalDate fecha;

    private Float calificacion;

}
