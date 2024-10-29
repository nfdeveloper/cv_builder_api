package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;
import io.github.nfdeveloper.cv_builder.repositories.CurriculoRepository;
import jakarta.transaction.Transactional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository repository;

    public List<Curriculo> listar() {
        return repository.findAll();
    }

    @Transactional
    public Curriculo criar(Curriculo Curriculo) {
        return repository.save(Curriculo);
    }
}
