package io.github.nfdeveloper.cv_builder.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoResponseDTO;
import io.github.nfdeveloper.cv_builder.services.ProjetoService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/projetos")
@CrossOrigin("*")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @GetMapping
    private ResponseEntity<List<ProjetoResponseDTO>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> criar(@RequestBody ProjetoCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }
}
