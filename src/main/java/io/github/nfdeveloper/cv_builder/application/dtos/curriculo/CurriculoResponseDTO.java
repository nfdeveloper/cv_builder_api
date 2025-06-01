package io.github.nfdeveloper.cv_builder.application.dtos.curriculo;

import java.time.LocalDate;
import java.util.List;

import io.github.nfdeveloper.cv_builder.application.dtos.cursos.CursoResponseDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurriculoResponseDTO {

    private Long id;
    private String nome;
    private String titulo;
    private String subTitulo;
    private LocalDate dataCurriculo;
    private String resumo;
    private String competenciasTecnicas;
    private List<ExperienciaResponseDTO> experiencias;
    private List<CursoResponseDTO> cursos;
}
