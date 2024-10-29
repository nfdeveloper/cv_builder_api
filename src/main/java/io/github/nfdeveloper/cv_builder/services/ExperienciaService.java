package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.entities.models.Experiencia;
import io.github.nfdeveloper.cv_builder.repositories.ExperienciaRepository;
import jakarta.transaction.Transactional;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository repository;

    public List<Experiencia> listar(){
        return repository.findAll();
    }

    @Transactional
    public Experiencia criar(Experiencia Experiencia) {
        return repository.save(Experiencia);
    }
}
