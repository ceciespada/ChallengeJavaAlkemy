package com.alkemy.challenge.challenge.controllers;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.service.impl.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoServiceImpl;

    @PostMapping
    public ResponseEntity<GeneroDTO>guardarGenero(@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoServiceImpl.guardarGenero(genero);

        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }
}
