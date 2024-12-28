package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_resumes")
public class Curriculo implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "titulo", length = 80)
    private String titulo;

    @Column(name = "subtitulo", length = 80)
    private String subTitulo;

    @Column(name = "dtCurriculo")
    private LocalDate dataCurriculo;

    @Column(name = "resumo", length = 1000)
    private String resumo;

    @Column(name = "competencias_tecnicas", length = 1000)
    private String competenciasTecnicas;
 
    @ManyToMany
    @JoinTable(
        name = "experiencias_curriculos",
        joinColumns = @JoinColumn(name = "curriculo_id"),
        inverseJoinColumns = @JoinColumn(name = "experiencia_id")
    )
    private List<Experiencia> experiencias;

    @ManyToMany
    @JoinTable(
        name = "cursos_curriculos",
        joinColumns = @JoinColumn(name = "curriculo_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Curriculo(CurriculoCreateDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.titulo = dto.getTitulo();
        this.subTitulo = dto.getSubTitulo();
        this.dataCurriculo = dto.getDataCurriculo();
        this.resumo = dto.getResumo();
        this.competenciasTecnicas = dto.getCompetenciasTecnicas();
    }

    public void defineCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    public void defineExperiencias(List<Experiencia> experiencias){
        this.experiencias = experiencias;
    }

    public void defineUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
