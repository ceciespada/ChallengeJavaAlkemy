package com.alkemy.challenge.challenge.controllers;




import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.service.IPeliculaService;
import com.alkemy.challenge.challenge.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    private IPersonajeService personajeService;

   /* @Autowired
    private IPeliculaService peliculaService;

    */

    //Create
    @PostMapping
    public ResponseEntity<PersonajeDTO>guardarPersonaje(@RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajeGuardado = personajeService.guardarPersonaje(personajeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    //Read
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>>listarTodosPersonaje(){
        List<PersonajeDTO> personajes = personajeService.listarTodosPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/{idPersonaje}")
    public ResponseEntity<PersonajeDTO>buscarPersonajeXid(@PathVariable Long idPersonaje){
        PersonajeDTO personajeDTO = personajeService.buscarPersonajeXid(idPersonaje);
        return ResponseEntity.ok(personajeDTO);
    }

    //Update
    @PutMapping("/{idPersonaje}")
    public ResponseEntity<PersonajeDTO> actualizarPersonaje(@PathVariable Long idPersonaje, @RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajeActualizado = personajeService.actualizarPersonaje(idPersonaje,personajeDTO);
        return ResponseEntity.ok().body(personajeActualizado);
    }


    //Delete
    @DeleteMapping("/{idPersonaje}")
    public ResponseEntity<Void> eliminarPersonaje(@PathVariable Long idPersonaje) {
        personajeService.eliminarPersonaje(idPersonaje);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
