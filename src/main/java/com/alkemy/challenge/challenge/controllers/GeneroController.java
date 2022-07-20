package com.alkemy.challenge.challenge.controllers;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entities.GeneroEntity;
import com.alkemy.challenge.challenge.service.IGeneroService;
import com.alkemy.challenge.challenge.service.impl.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private IGeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>>listarTodosGeneros(){
        List<GeneroDTO> generos = generoService.listarTodosGeneros();
        return ResponseEntity.ok().body(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO>buscarGeneroXid(@PathVariable Long id){
       GeneroDTO generoDTO = generoService.buscarGeneroXid(id);
        return ResponseEntity.ok(generoDTO);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO>guardarGenero(@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoService.guardarGenero(genero);

        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }



}
