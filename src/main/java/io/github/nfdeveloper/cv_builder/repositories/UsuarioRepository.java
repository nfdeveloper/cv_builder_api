package io.github.nfdeveloper.cv_builder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
