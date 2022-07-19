package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.GeneroDTO;

import java.util.List;

public interface IGeneroService {
   GeneroDTO guardarGenero(GeneroDTO dto);
   List<GeneroDTO> listarTodosGeneros();
}
