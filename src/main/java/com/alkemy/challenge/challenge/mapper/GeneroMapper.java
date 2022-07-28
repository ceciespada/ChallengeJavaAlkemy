package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2ENtity(GeneroBasicDTO dto){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;

    }
    public GeneroBasicDTO generoEntity2BasicDTO(GeneroEntity entity){
        GeneroBasicDTO dto = new GeneroBasicDTO();
        // Devuelve entidad así que necesito el id
        dto.setIdGenero(entity.getIdGenero());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;

    }

    public List<GeneroBasicDTO>generoEntityList2DTOList(List<GeneroEntity> generoEntities){
        List<GeneroBasicDTO> dtos = new ArrayList<>();
        for (GeneroEntity generoEntity : generoEntities){
            dtos.add(generoEntity2BasicDTO(generoEntity));
        }
        return dtos;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
        GeneroDTO dto = new GeneroDTO();
        // Devuelve entidad así que necesito el id
        dto.setIdGenero(entity.getIdGenero());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;

    }

    public Set<GeneroDTO> generoEntitySet2DTOSet(Set<GeneroEntity> generoEntitiesSet){
        Set<GeneroDTO> dtos = new HashSet<>();
        for (GeneroEntity generoEntity : generoEntitiesSet){
            dtos.add(generoEntity2DTO(generoEntity));
        }
        return dtos;
    }


}
