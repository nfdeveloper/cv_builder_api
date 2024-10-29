package io.github.nfdeveloper.cv_builder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long>{

}
