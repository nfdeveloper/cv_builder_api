package io.github.nfdeveloper.cv_builder.application.dtos.experiencias;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private String tecnologias;
    private Status status = Status.ATIVO;
}
