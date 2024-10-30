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

import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaResponseDTO;
import io.github.nfdeveloper.cv_builder.services.ExperienciaService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService service;

    @GetMapping
    public ResponseEntity<List<ExperienciaResponseDTO>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @PostMapping
    public ResponseEntity<ExperienciaResponseDTO> criar(@RequestBody ExperienciaCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }
}
