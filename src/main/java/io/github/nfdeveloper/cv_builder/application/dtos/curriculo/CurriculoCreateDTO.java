package io.github.nfdeveloper.cv_builder.application.dtos.curriculo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
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
public class CurriculoCreateDTO {

    private Long id;
    private String nome;
    private String titulo;
    private String subTitulo;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataCurriculo;
    private String resumo;
    private String competenciasTecnicas;
    private List<Long> experiencias;
    private List<Long> cursos;

}
