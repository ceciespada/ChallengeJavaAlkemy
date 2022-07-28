package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;

import java.util.List;

public interface IPersonajeService {
    PersonajeDTO guardarPersonaje(PersonajeDTO personajeDTO);
    List<PersonajeDTO> listarTodosPersonajes();
    void eliminarPersonaje(Long idPersonaje);
    PersonajeDTO buscarPersonajeXid(Long idPersonaje);
    PersonajeDTO actualizarPersonaje(Long idPersonaje, PersonajeDTO dto) throws BadRequestException;
    //TODO: addPelicula / removePelicula
}
