package io.github.nfdeveloper.cv_builder.entities.models;

import java.io.Serializable;

import io.github.nfdeveloper.cv_builder.entities.enums.Role;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_users")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nome", length = 120)
    private String nome;

    @Column(name = "sobrenome", length = 80)
    private String sobrenome;

    @Column(name = "cpf", unique = true, length = 20)
    private String cpf;

    @Column(name = "username", unique = true, length = 80)
    private String username;

    private String password;

    private Role permissao = Role.USUARIO;
    
    private Status status;

    private String gitHub;

    private String linkedin;

    @Embedded
	private Endereco endereco;

    @Embedded
	private Contato contato;
}
