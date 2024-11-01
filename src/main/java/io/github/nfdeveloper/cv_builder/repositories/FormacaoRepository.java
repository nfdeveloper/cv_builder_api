package io.github.nfdeveloper.cv_builder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Formacao;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface FormacaoRepository extends JpaRepository<Formacao, Long>{

    List<Formacao> findByUsuario(Usuario usuario);
}
