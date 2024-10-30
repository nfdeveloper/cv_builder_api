package io.github.nfdeveloper.cv_builder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Experiencia;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{

    List<Experiencia> findByUsuario(Usuario usuario);
}
