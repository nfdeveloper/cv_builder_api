package io.github.nfdeveloper.cv_builder.application.dtos.projetos;

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
public class ProjetoCreateDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String tecnologias;
    private Integer duracao;
    private Status status = Status.ATIVO;
    private Long experienciaId;
}
