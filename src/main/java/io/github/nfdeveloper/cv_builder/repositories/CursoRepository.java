package io.github.nfdeveloper.cv_builder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface CursoRepository extends JpaRepository<Curso, Long>{

    List<Curso> findByUsuario(Usuario usuario);
}
