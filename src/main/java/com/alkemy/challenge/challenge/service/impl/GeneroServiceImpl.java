package com.alkemy.challenge.challenge.service.impl;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.service.IGeneroService;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements IGeneroService {

    public GeneroDTO guardarGenero (GeneroDTO dto){
        //TODO:guardar genero
        System.out.println("Guardar Genero");
        return dto;
    }
}
