package io.github.nfdeveloper.cv_builder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long>{

    List<Curriculo> findByUsuario(Usuario usuario);
}
