package com.alkemy.challenge.challenge.controllers;

import com.alkemy.challenge.challenge.dto.GeneroBasicDTO;
import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    //Create
    @PostMapping
    public ResponseEntity<PeliculaDTO> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaGuardada = peliculaService.guardarPelicula(peliculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }
    //Read
    @GetMapping
    public ResponseEntity<List<PeliculaDTO>>listarTodasPeliculas(){
        List<PeliculaDTO> peliculaDTOList = peliculaService.listarTodasPeliculas();
        return ResponseEntity.ok().body(peliculaDTOList);
    }

    @GetMapping("/{idPelicula}")
    public ResponseEntity<PeliculaDTO>buscarPeliculaXid(@PathVariable Long idPelicula){
        PeliculaDTO peliculaDTO = peliculaService.buscarPeliculaXid(idPelicula);
        return ResponseEntity.ok(peliculaDTO);
    }

    //Update
    @PutMapping("/{idPelicula}")
    public ResponseEntity<PeliculaDTO> actualizarPelicula(@PathVariable Long idPelicula, @RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaActualizada = peliculaService.actualizarPelicula(idPelicula,peliculaDTO);
        return ResponseEntity.ok().body(peliculaActualizada);
    }
    //Delete
    @DeleteMapping("/{idPelicula}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long idPelicula) {
        peliculaService.eliminarPelicula(idPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
