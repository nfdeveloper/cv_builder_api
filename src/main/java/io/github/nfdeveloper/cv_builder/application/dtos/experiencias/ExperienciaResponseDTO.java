package io.github.nfdeveloper.cv_builder.application.dtos.experiencias;

import java.time.LocalDateTime;

import io.github.nfdeveloper.cv_builder.entities.models.Experiencia;
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
public class ExperienciaResponseDTO {

    private Long id;
    private String empresa;
    private String funcao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String descricao;
    private Boolean empregoAtual;

    private String status;

    public ExperienciaResponseDTO(Experiencia experiencia){
        this.id = experiencia.getId();
        this.empresa = experiencia.getEmpresa();
        this.funcao = experiencia.getFuncao();
        this.dataInicio = experiencia.getDataInicio();
        this.dataFim = experiencia.getDataFim();
        this.descricao = experiencia.getDescricao();
        this.empregoAtual = experiencia.getEmpregoAtual();
        this.status = experiencia.getStatus().name();
    }
}
