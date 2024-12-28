package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.nfdeveloper.cv_builder.application.dtos.formacoes.FormacaoCreateDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.enums.StatusCurso;
import io.github.nfdeveloper.cv_builder.entities.enums.TipoFormacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_formations")
public class Formacao implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "titulo", length = 120)
    private String titulo;
    private TipoFormacao tipo;
    private StatusCurso situacao;
    private Status status;

    @Column(name = "previsao_termino")
    private LocalDate previsaoTermino;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Formacao(FormacaoCreateDTO dto){
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.situacao = dto.getSituacao();
        this.tipo = dto.getTipo();
        this.dataConclusao = dto.getDataConclusao();
        this.previsaoTermino = dto.getPrevisaoTermino();
        this.status = dto.getStatus() != null ? dto.getStatus() : Status.ATIVO;
    }

    public void defineUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
