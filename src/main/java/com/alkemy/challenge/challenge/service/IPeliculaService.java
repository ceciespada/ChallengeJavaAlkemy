package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;

import java.util.List;

public interface IPeliculaService {
    PeliculaDTO guardarPelicula(PeliculaDTO peliculaDTO);
    List<PeliculaDTO> listarTodasPeliculas();
    void eliminarPelicula(Long idPelicula);
    PeliculaDTO buscarPeliculaXid(Long idPelicula);
    PeliculaDTO actualizarPelicula(Long idPelicula, PeliculaDTO peliculaDTO) throws BadRequestException;
    //TODO: addPersonaje /removePersonaje / addGenero / removeGenero
}
