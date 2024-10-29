package io.github.nfdeveloper.cv_builder.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.nfdeveloper.cv_builder.application.dtos.usuarios.UsuarioLoginDTO;
import io.github.nfdeveloper.cv_builder.application.exceptions.ErrorMessage;
import io.github.nfdeveloper.cv_builder.jwt.JwtToken;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUserDetailsService detailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody UsuarioLoginDTO dto, HttpServletRequest request){
        try {
            UsernamePasswordAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            
            authenticationManager.authenticate(authenticationToken);
            
            JwtToken token = detailsService.getTokenAuthenticated(dto.getUsername());
            
            return ResponseEntity.ok(token);

        } catch(AuthenticationException ex){
            log.warn("Bad Credentials.");
        }

        return ResponseEntity  
                .badRequest()
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "Credenciais inválidas"));
    }
}
