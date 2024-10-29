package io.github.nfdeveloper.cv_builder.application.dtos.cursos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.cv_builder.entities.models.Curso;
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
public class CursoResponseDTO {
    private Long id;
    private String titulo;
    private String instituicao;
    private Double cargaHoraria;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dtTermino;
    private String descricao;
    private String tecnologias;
    private String status;

    public CursoResponseDTO(Curso curso){
        this.id = curso.getId();
        this.titulo = curso.getTitulo();
        this.instituicao = curso.getInstituicao();
        this.cargaHoraria = curso.getCargaHoraria();
        this.dtTermino = curso.getDtTermino();
        this.descricao = curso.getDescricao();
        this.tecnologias = curso.getTecnologias();
        this.status = curso.getStatus().name();
    }
}
