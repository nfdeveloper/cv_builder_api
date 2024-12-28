package io.github.nfdeveloper.cv_builder.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoResponseDTO;
import io.github.nfdeveloper.cv_builder.services.CurriculoService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/curriculos")
@CrossOrigin("*")
public class CurriculoController {

    @Autowired
    private CurriculoService service;

    @GetMapping
    public ResponseEntity<List<CurriculoResponseDTO>> listar(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @PostMapping
    public ResponseEntity<CurriculoResponseDTO> criar(@RequestBody CurriculoCreateDTO dto, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }
}
