package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;

import java.util.List;

public interface IGeneroService {
   GeneroDTO guardarGenero(GeneroDTO dto);
   List<GeneroDTO> listarTodosGeneros();
   void eliminarGenero(GeneroDTO dto);
   GeneroDTO buscarGeneroXid(Long id);



}
