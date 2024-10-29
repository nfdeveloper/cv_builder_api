package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.repositories.CursoRepository;
import jakarta.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> listar(){
        return repository.findAll();
    }

    @Transactional
    public Curso criar(Curso Curso) {
        return repository.save(Curso);
    }
}
