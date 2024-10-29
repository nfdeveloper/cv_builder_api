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

    private String nome;

    private String sobrenome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    private Role permissao;
    
    private Status status;

    @Embedded
	private Endereco endereco;

    @Embedded
	private Contato contato;
}
