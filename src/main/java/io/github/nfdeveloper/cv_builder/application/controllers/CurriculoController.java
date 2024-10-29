package io.github.nfdeveloper.cv_builder.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;
import io.github.nfdeveloper.cv_builder.repositories.CurriculoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/curriculos")
public class CurriculoController {

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
