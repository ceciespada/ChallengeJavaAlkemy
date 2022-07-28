package com.alkemy.challenge.challenge.controllers;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private IGeneroService generoService;


    //Create
    @PostMapping
    public ResponseEntity<GeneroBasicDTO>guardarGenero(@RequestBody GeneroBasicDTO generoDTO){
        GeneroBasicDTO generoGuardado = generoService.guardarGenero(generoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //Read
    @GetMapping
    public ResponseEntity<List<GeneroBasicDTO>>listarTodosGeneros(){
        List<GeneroBasicDTO> generos = generoService.listarTodosGeneros();
        return ResponseEntity.ok().body(generos);
    }

    @GetMapping("/{idGenero}")
    public ResponseEntity<GeneroBasicDTO>buscarGeneroXid(@PathVariable Long idGenero){
        GeneroBasicDTO generoBasicDTO = generoService.buscarGeneroXid(idGenero);
        return ResponseEntity.ok(generoBasicDTO);
    }


    //Update
    @PutMapping("/{idGenero}")
    public ResponseEntity<GeneroBasicDTO> actualizarGenero(@PathVariable Long idGenero, @RequestBody GeneroBasicDTO generoBasicDTO){
        GeneroBasicDTO generoActualizado = generoService.actualizarGenero(idGenero,generoBasicDTO);
        return ResponseEntity.ok().body(generoActualizado);
    }

    //Delete
    @DeleteMapping("/{idGenero}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable Long idGenero){
        generoService.eliminarGenero(idGenero);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}
