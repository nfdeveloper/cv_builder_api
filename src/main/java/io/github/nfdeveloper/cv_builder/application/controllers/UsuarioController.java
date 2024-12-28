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

import io.github.nfdeveloper.cv_builder.application.dtos.usuarios.UsuarioResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
     @Autowired
    private JwtUserDetailsService jwtService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/usuario-logado")
    public ResponseEntity<UsuarioResponseDTO> usuarioLogado(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponseDTO(jwtService.getUsuarioByToken(request)));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(usuario));
    }
}
