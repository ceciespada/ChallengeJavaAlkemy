package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.PeliculaBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import com.alkemy.challenge.challenge.repository.GeneroRepository;
import com.alkemy.challenge.challenge.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeRepository personajeRepository;


    public PeliculaEntity peliculaBasicDTO2Entity(PeliculaBasicDTO dto) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFecha(dto.getFecha());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        return peliculaEntity;

    }

    public PeliculaBasicDTO peliculaEntity2BasicDTO(PeliculaEntity entity) {
        PeliculaBasicDTO dto = new PeliculaBasicDTO();
        // Devuelve entidad así que necesito el id
        dto.setIdPelicula(entity.getIdPelicula());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFecha(entity.getFecha());
        dto.setCalificacion(entity.getCalificacion());
        return dto;

    }
    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> peliculaEntities) {
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (PeliculaEntity peliculaEntity : peliculaEntities) {
            dtos.add(peliculaEntity2DTO(peliculaEntity));
        }
        return dtos;
    }

    public List<PeliculaBasicDTO> peliculaEntityList2BasicDTOList(List<PeliculaEntity> peliculaEntities) {
        List<PeliculaBasicDTO> dtos = new ArrayList<>();
        for (PeliculaEntity peliculaEntity : peliculaEntities) {
            dtos.add(peliculaEntity2BasicDTO(peliculaEntity));
        }
        return dtos;
    }

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFecha(dto.getFecha());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setPersonajesSet(dto.getPersonajeEntitySet());
        peliculaEntity.setGenerosSet(dto.getGeneroEntitySet());
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity) {
        PeliculaDTO dto = new PeliculaDTO();
        // Devuelve entidad así que necesito el id
        dto.setIdPelicula(entity.getIdPelicula());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFecha(entity.getFecha());
        dto.setCalificacion(entity.getCalificacion());
        dto.setGeneroEntitySet(entity.getGenerosSet());
        dto.setPersonajeEntitySet(entity.getPersonajesSet());;
        return dto;

    }
}