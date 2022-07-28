package com.alkemy.challenge.challenge.service.impl;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;
import com.alkemy.challenge.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.challenge.repository.PeliculaRepository;
import com.alkemy.challenge.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.challenge.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    //Create
    public PeliculaDTO guardarPelicula(PeliculaDTO peliculaDTO) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setFecha(peliculaDTO.getFecha());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setPersonajesSet(peliculaDTO.getPersonajeEntitySet());
        /*personajeRepository.getReferenceById(idPersonaje);*/
        PeliculaEntity peliculaGuardada = peliculaRepository.save(peliculaEntity);
        PeliculaDTO peliculaGuardadaDTO = peliculaMapper.peliculaEntity2DTO(peliculaGuardada);
        return peliculaGuardadaDTO;
    }


    //Read
    public List<PeliculaDTO> listarTodasPeliculas() {
        List<PeliculaEntity> peliculaEntities = peliculaRepository.findAll();
        List<PeliculaDTO> peliculaDTOS = peliculaMapper.peliculaEntityList2DTOList(peliculaEntities);
        return peliculaDTOS;
    }

    public PeliculaDTO buscarPeliculaXid(Long idPelicula) {
        Optional<PeliculaEntity> peliculaOptionalEntity = peliculaRepository.findById(idPelicula);
        PeliculaEntity peliculaEncontrada = peliculaOptionalEntity.get();
        PeliculaDTO peliculaEncontradaDTO = peliculaMapper.peliculaEntity2DTO(peliculaEncontrada);
        return peliculaEncontradaDTO;
    }

    //Delete
    public void eliminarPelicula(Long idPelicula) {
        Optional<PeliculaEntity> peliculaOptionalEntity = peliculaRepository.findById(idPelicula);
        PeliculaEntity peliculaEncontrada = peliculaOptionalEntity.get();
        peliculaRepository.delete(peliculaEncontrada);

    }



    //Update --> devolver pelicula completa pero solo cambiar atributos de pelicula
    public PeliculaDTO actualizarPelicula(Long idPelicula, PeliculaDTO peliculaDTO) throws BadRequestException {
        return null;
    }
}
