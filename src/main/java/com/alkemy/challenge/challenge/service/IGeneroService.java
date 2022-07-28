package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;

import java.util.List;

public interface IGeneroService {
   GeneroBasicDTO guardarGenero(GeneroBasicDTO dto);
   List<GeneroBasicDTO> listarTodosGeneros();
   void eliminarGenero(Long idGenero);
   GeneroBasicDTO buscarGeneroXid(Long idGenero);
   GeneroBasicDTO actualizarGenero(Long idGenero, GeneroBasicDTO dto) throws BadRequestException;



}
