package com.alkemy.challenge.challenge.service.impl;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.mapper.GeneroMapper;
import com.alkemy.challenge.challenge.repository.GeneroRepository;
import com.alkemy.challenge.challenge.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;


    public GeneroDTO guardarGenero (GeneroDTO generoDTO){
        GeneroEntity entity = generoMapper.generoDTO2ENtity(generoDTO);
        GeneroEntity generoGuardado = generoRepository.save(entity);
        GeneroDTO result = generoMapper.generoEntity2DTO(generoGuardado);
        //System.out.println("Guardar Genero");
        return result;
    }


    public List<GeneroDTO> listarTodosGeneros() {
        List<GeneroEntity> generoEntities = generoRepository.findAll();
        List<GeneroDTO> generoDTOs = generoMapper.generoEntityList2DTOList(generoEntities);
        return generoDTOs;
    }

     public void eliminarGenero(GeneroDTO dto) {
        GeneroEntity entity = generoMapper.generoDTO2ENtity(dto);
        generoRepository.delete(entity);
    }


   public GeneroDTO buscarGeneroXid(Long id) {
       Optional<GeneroEntity> generoOptionalEntity = generoRepository.findById(id);
       GeneroEntity generoEncontrado = generoOptionalEntity.get();
       GeneroDTO result = generoMapper.generoEntity2DTO(generoEncontrado);
       return result;
    }




}
