package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.entities.PeliculaEntity;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonajeMapper {
    public PersonajeEntity personajeDTO2ENtity(PersonajeDTO dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity){
        PersonajeDTO dto = new PersonajeDTO();
        // Devuelve entidad así que necesito el id
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        return dto;

    }

    public List<PersonajeDTO> personajeEntityList2DTOList(List<PersonajeEntity> personajeEntities){
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();
        for (PersonajeEntity personajeEntity : personajeEntities){
            personajeDTOS.add(personajeEntity2DTO(personajeEntity));
        }
        return personajeDTOS;
    }
}
