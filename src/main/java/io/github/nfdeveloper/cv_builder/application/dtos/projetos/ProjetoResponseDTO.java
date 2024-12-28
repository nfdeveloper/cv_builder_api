package io.github.nfdeveloper.cv_builder.application.dtos.projetos;

import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.models.Projeto;
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
public class ProjetoResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String tecnologias;
    private Integer duracao;
    private Status status;

    public ProjetoResponseDTO(Projeto obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.descricao = obj.getDescricao();
        this.tecnologias = obj.getTecnologias();
        this.duracao = obj.getDuracao();
        this.status = obj.getStatus();
    }
}
