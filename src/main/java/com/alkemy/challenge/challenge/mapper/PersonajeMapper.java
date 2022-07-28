package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
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
        dto.setIdPersonaje(entity.getIdPersonaje());
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

    public List<PersonajeBasicDTO> personajeEntityList2BasicDTOList(List<PersonajeEntity> personajeEntities){
        List<PersonajeBasicDTO> personajeBasicDTOS = new ArrayList<>();
        for (PersonajeEntity personajeEntity : personajeEntities){
            personajeBasicDTOS.add(personajeEntity2BasicDTO(personajeEntity));
        }
        return personajeBasicDTOS;
    }
    public PersonajeBasicDTO personajeEntity2BasicDTO(PersonajeEntity entity){
        PersonajeBasicDTO dto = new PersonajeBasicDTO();
        // Devuelve entidad así que necesito el id
        dto.setIdPersonaje(entity.getIdPersonaje());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        return dto;

    }
}
