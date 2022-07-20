package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.entities.PeliculaEntity;

import java.util.ArrayList;
import java.util.List;

public class PeliculaMapper {

    public PeliculaEntity peliculaDTO2ENtity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFecha(dto.getFecha());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        return peliculaEntity;

    }
    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity){
        PeliculaDTO dto = new PeliculaDTO();
        // Devuelve entidad así que necesito el id
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFecha(entity.getFecha());
        dto.setCalificacion(entity.getCalificacion());
        return dto;

    }

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> peliculaEntities){
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (PeliculaEntity peliculaEntity : peliculaEntities){
            dtos.add(peliculaEntity2DTO(peliculaEntity));
        }
        return dtos;
    }
}
