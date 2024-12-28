package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaCreateDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_experiences")
public class Experiencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

     @Column(name = "empresa", length = 120)
    private String empresa;

    @Column(name = "funcao", length = 80)
    private String funcao;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_fim")
    private LocalDate dataFim;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "emprego_atual")
    private Boolean empregoAtual;

    @Column(name = "tecnologias", length = 500)
    private String tecnologias;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany(mappedBy = "experiencias")
    private List<Curriculo> curriculos;

    @OneToMany(mappedBy = "experiencia")
    private List<Projeto> projetos;

    public Experiencia(ExperienciaCreateDTO dto){
        this.id = dto.getId();
        this.empresa = dto.getEmpresa();
        this.funcao = dto.getFuncao();
        this.dataInicio = dto.getDataInicio();
        this.dataFim = dto.getDataFim();
        this.descricao = dto.getDescricao();
        this.empregoAtual = dto.getDataFim() != null ? false : true;
        this.status = dto.getStatus();
        this.tecnologias = dto.getTecnologias();
    }

    public void defineUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
