package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2ENtity(GeneroDTO dto){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;

    }
    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
        GeneroDTO dto = new GeneroDTO();
        // Devuelve entidad así que necesito el id
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;

    }

    public List<GeneroDTO>generoEntityList2DTOList(List<GeneroEntity> generoEntities){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity generoEntity : generoEntities){
            dtos.add(generoEntity2DTO(generoEntity));
        }
        return dtos;
    }


}
