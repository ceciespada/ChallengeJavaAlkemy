package com.alkemy.challenge.challenge.service.impl;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;
import com.alkemy.challenge.challenge.mapper.GeneroMapper;
import com.alkemy.challenge.challenge.repository.GeneroRepository;
import com.alkemy.challenge.challenge.repository.PeliculaRepository;
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

    /*@Autowired
    private PeliculaRepository peliculaRepository;

     */

    //Create
    public GeneroBasicDTO guardarGenero (GeneroBasicDTO generoBasicDTO){
        GeneroEntity generoEntity =new GeneroEntity();
        generoEntity.setNombre(generoBasicDTO.getNombre());
        generoEntity.setImagen(generoBasicDTO.getImagen());
        GeneroEntity generoGuardado = generoRepository.save(generoEntity);
        GeneroBasicDTO generoGuardadoDTO = generoMapper.generoEntity2BasicDTO(generoGuardado);
        return generoGuardadoDTO;
    }

    //Read
    public List<GeneroBasicDTO> listarTodosGeneros() {
        List<GeneroEntity> generoEntities = generoRepository.findAll();
        List<GeneroBasicDTO> generoBasicDTOS = generoMapper.generoEntityList2DTOList(generoEntities);
        return generoBasicDTOS;
    }
    //Delete
     public void eliminarGenero(Long idGenero) {
        Optional<GeneroEntity> generoOptionalEntity = generoRepository.findById(idGenero);
        GeneroEntity generoEncontrado = generoOptionalEntity.get();
        generoRepository.delete(generoEncontrado);
    }

    //Read
   public GeneroBasicDTO buscarGeneroXid(Long idGenero) {
       Optional<GeneroEntity> generoOptionalEntity = generoRepository.findById(idGenero);
       if(generoOptionalEntity.isPresent()){
       GeneroEntity generoEncontrado = generoOptionalEntity.get();
       GeneroBasicDTO generoEncontradoDTO = generoMapper.generoEntity2BasicDTO(generoEncontrado);
       return generoEncontradoDTO;
       }
       else{
           throw new BadRequestException("El genero buscado no fue encontrado");
       }
    }

    //Update
    public GeneroBasicDTO actualizarGenero(Long idGenero, GeneroBasicDTO generoBasicDTO) throws BadRequestException {
        Optional<GeneroEntity> generoBuscadoParaActualizar = generoRepository.findById(idGenero);
        if(generoBuscadoParaActualizar.isPresent()){
            GeneroEntity generoEncontrado = generoBuscadoParaActualizar.get();
            generoEncontrado.setImagen(generoBasicDTO.getImagen());
            generoEncontrado.setNombre(generoBasicDTO.getNombre());
            GeneroEntity generoGuardado = generoRepository.save(generoEncontrado);
            GeneroBasicDTO generoActualizado = generoMapper.generoEntity2BasicDTO(generoGuardado);
            return generoActualizado;
        }
        else{
            throw new BadRequestException("El genero buscado para actualizar no fue encontrado");
        }
    }


}
