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

import io.github.nfdeveloper.cv_builder.application.dtos.formacoes.FormacaoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.formacoes.FormacaoResponseDTO;
import io.github.nfdeveloper.cv_builder.services.FormacaoService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/formacoes")
@CrossOrigin("*")
public class FormacaoController {

    @Autowired
    private FormacaoService service;

    @GetMapping
    public ResponseEntity<List<FormacaoResponseDTO>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.list(request));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<FormacaoResponseDTO>> listarAtivos(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAtivos(request));
    }

    @PostMapping
    public ResponseEntity<FormacaoResponseDTO> criar(@RequestBody FormacaoCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }
}
