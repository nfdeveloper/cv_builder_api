package io.github.nfdeveloper.cv_builder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Projeto;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

    List<Projeto> findByUsuario(Usuario usuario);
}
