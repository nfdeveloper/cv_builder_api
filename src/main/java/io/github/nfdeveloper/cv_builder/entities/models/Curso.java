package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.github.nfdeveloper.cv_builder.application.dtos.cursos.CursoCreateDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_courses")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "titulo", length = 120)
    private String titulo;

    @Column(name = "instituicao", length = 120)
    private String instituicao;

    @Column(name = "carga_horaria")
    private Double cargaHoraria;

    @Column(name = "dt_termino")
    private LocalDateTime dtTermino;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "tecnologias", length = 500)
    private String tecnologias;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany(mappedBy = "cursos")
    private List<Curriculo> curriculos;

    public Curso(CursoCreateDTO dto){
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.instituicao = dto.getInstituicao();
        this.cargaHoraria = dto.getCargaHoraria();
        this.dtTermino = dto.getDtTermino();
        this.descricao = dto.getDescricao();
        this.tecnologias = dto.getTecnologias();
        this.status = dto.getStatus();
    }

    public void defineUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
