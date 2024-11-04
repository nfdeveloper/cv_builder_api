package io.github.nfdeveloper.cv_builder.application.dtos.cursos;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.enums.StatusCurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CursoCreateDTO {
    private Long id;
    private String titulo;
    private String instituicao;
    private Double cargaHoraria;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dtTermino;
    private String descricao;
    private String tecnologias;
    private Status status = Status.ATIVO;
    private StatusCurso situacao;
}
