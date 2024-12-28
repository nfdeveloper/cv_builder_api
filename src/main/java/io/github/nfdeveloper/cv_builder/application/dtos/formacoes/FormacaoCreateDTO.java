package io.github.nfdeveloper.cv_builder.application.dtos.formacoes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.enums.StatusCurso;
import io.github.nfdeveloper.cv_builder.entities.enums.TipoFormacao;
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
public class FormacaoCreateDTO {

    private Long id;
    private String titulo;
    private TipoFormacao tipo;
    private StatusCurso situacao;
    private Status status;
    private LocalDate previsaoTermino;
    private LocalDate dataConclusao;
}
