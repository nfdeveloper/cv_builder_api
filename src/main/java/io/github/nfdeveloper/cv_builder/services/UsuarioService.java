package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar(){
        return repository.findAll();
    }

    @Transactional
    public Usuario criar(Usuario usuario) {
        return repository.save(usuario);
    }
}
