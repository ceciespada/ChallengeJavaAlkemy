package com.alkemy.challenge.challenge.controllers;

import com.alkemy.challenge.challenge.exceptions.BadRequestException;
import com.alkemy.challenge.challenge.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> tratamientoErrorResourceNotFound(ResourceNotFoundException rnfe, WebRequest wr){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atención -> Detalle: "+ rnfe.getMessage());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> tratamientoErrorBadRequest(BadRequestException bre, WebRequest wre){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atención -> Detalle: "+ bre.getMessage());
    }
}