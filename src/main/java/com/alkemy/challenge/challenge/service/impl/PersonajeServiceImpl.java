package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import com.alkemy.challenge.challenge.exceptions.BadRequestException;
import com.alkemy.challenge.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.challenge.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    //Create
    public PersonajeDTO guardarPersonaje(PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(personajeDTO.getNombre());
        personajeEntity.setImagen(personajeDTO.getImagen());
        personajeEntity.setPeso(personajeDTO.getPeso());
        personajeEntity.setEdad(personajeDTO.getEdad());
        personajeEntity.setHistoria(personajeDTO.getHistoria());
        personajeEntity.setPeliculasSet(personajeDTO.getPeliculaEntitySet());
        PersonajeEntity personajeGuardado = personajeRepository.save(personajeEntity);
        PersonajeDTO personajeGuardadoDTO = personajeMapper.personajeEntity2DTO(personajeGuardado);
        return personajeGuardadoDTO;
    }
    //Read
    public List<PersonajeDTO> listarTodosPersonajes() {
        List<PersonajeEntity> personajeEntities = personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOS = personajeMapper.personajeEntityList2DTOList(personajeEntities);
        return personajeDTOS;
    }
    public PersonajeDTO buscarPersonajeXid(Long idPersonaje) {
        Optional<PersonajeEntity> personajeOptionalEntity = personajeRepository.findById(idPersonaje);
        PersonajeEntity personajeEncontrado = personajeOptionalEntity.get();
        PersonajeDTO personajeEncontradoDTO = personajeMapper.personajeEntity2DTO(personajeEncontrado);
        return personajeEncontradoDTO;
    }

    //Delete
    public void eliminarPersonaje(Long idPersonaje) {
        Optional<PersonajeEntity> personajeOptionalEntity = personajeRepository.findById(idPersonaje);
        PersonajeEntity personajeEncontrado = personajeOptionalEntity.get();
        personajeRepository.delete(personajeEncontrado);

    }

    //Update
    public PersonajeDTO actualizarPersonaje(Long idPersonaje, PersonajeDTO personajeDTO) throws BadRequestException {
        Optional<PersonajeEntity>personajeBuscadoParaActualizar = personajeRepository.findById(idPersonaje);
        if(personajeBuscadoParaActualizar.isPresent()){
            PersonajeEntity personajeEncontrado = personajeBuscadoParaActualizar.get();
            personajeEncontrado.setNombre(personajeDTO.getNombre());
            personajeEncontrado.setImagen(personajeDTO.getImagen());
            personajeEncontrado.setEdad(personajeDTO.getEdad());
            personajeEncontrado.setPeso(personajeDTO.getPeso());
            personajeEncontrado.setHistoria(personajeDTO.getHistoria());
            PersonajeEntity personajeGuardado = personajeRepository.save(personajeEncontrado);
            PersonajeDTO personajeActualizado = personajeMapper.personajeEntity2DTO(personajeGuardado);

            return personajeActualizado;
        }else {
            throw new BadRequestException("El personaje buscado para actualizar no fue encontrado");
        }
    }
}
