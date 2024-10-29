package io.github.nfdeveloper.cv_builder.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.services.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

     @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso Curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(Curso));
    }
}
