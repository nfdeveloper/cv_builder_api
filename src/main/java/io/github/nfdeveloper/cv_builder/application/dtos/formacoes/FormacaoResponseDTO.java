package io.github.nfdeveloper.cv_builder.application.dtos.formacoes;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
import io.github.nfdeveloper.cv_builder.entities.models.Formacao;
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
public class FormacaoResponseDTO {
    private Long id;
    private String titulo;
    private String tipo;
    private String situacao;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime previsaoTermino;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dataConclusao;

    public FormacaoResponseDTO(Formacao formacao){
        this.id = formacao.getId();
        this.titulo = formacao.getTitulo();
        this.tipo = formacao.getTipo().name();
        this.situacao = formacao.getSituacao().name();
        this.previsaoTermino = formacao.getPrevisaoTermino();
        this.dataConclusao = formacao.getDataConclusao();
    }
}
