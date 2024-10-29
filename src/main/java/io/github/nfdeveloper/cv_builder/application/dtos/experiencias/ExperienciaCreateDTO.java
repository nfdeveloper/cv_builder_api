package io.github.nfdeveloper.cv_builder.application.dtos.experiencias;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
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
public class ExperienciaCreateDTO {

    private Long id;
    private String empresa;
    private String funcao;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataInicio;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataFim;
    private String descricao;

    private Status status = Status.ATIVO;
}
