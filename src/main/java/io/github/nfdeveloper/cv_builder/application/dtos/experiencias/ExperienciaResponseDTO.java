package io.github.nfdeveloper.cv_builder.application.dtos.experiencias;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoResponseDTO;
import io.github.nfdeveloper.cv_builder.config.CustomLocalDateTimeDeserializer;
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
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDate dataInicio;
    private String tecnologias;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDate dataFim;
    private String descricao;
    private Boolean empregoAtual;
    private List<ProjetoResponseDTO> projetos;

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
        this.tecnologias = experiencia.getTecnologias();
        this.projetos = experiencia.getProjetos()
                                   .stream()
                                   .map(p -> new ProjetoResponseDTO(p))
                                   .toList();
    }
}
