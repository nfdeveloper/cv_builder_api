package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.application.dtos.usuarios.UsuarioResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Role;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
   

    public List<Usuario> listar(){
        return repository.findAll();
    }

    @Transactional
    public Usuario criar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    public Usuario buscarPorUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> {
            throw new EntityNotFoundException("Usuário não encontrado.");
        });
    }

    public Role buscarRolePorUsername(String username) {
        return repository.findRoleByUsername(username);
    }
}
