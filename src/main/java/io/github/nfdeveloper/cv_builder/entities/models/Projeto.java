package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;

import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoCreateDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
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
@Table(name = "tb_projects")
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "titulo", length = 120)
    private String titulo;

    @Column(name = "descricao", length = 1000)
    private String descricao;

    @Column(name = "tecnologias", length = 500)
    private String tecnologias;

    @Column(name = "duracao")
    private Integer duracao;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "experiencia_id")
    private Experiencia experiencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Projeto(ProjetoCreateDTO dto) {
        this.id = dto.getId() != null ? dto.getId() : null;
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.tecnologias = dto.getTecnologias();
        this.duracao = dto.getDuracao();
        this.status = dto.getStatus();
    }

    public void defineExperiencia(Experiencia experiencia){
        this.experiencia = experiencia;
    }

    public void defineUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
