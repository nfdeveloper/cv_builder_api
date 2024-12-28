package io.github.nfdeveloper.cv_builder.application.dtos.usuarios;

import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.models.Contato;
import io.github.nfdeveloper.cv_builder.entities.models.Endereco;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
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
public class UsuarioResponseDTO {

    private String nome;
    private String cpf;
    private String gitHub;
    private String linkedin;
	private Endereco endereco;
	private Contato contato;

    public UsuarioResponseDTO(Usuario obj){
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.gitHub = obj.getGitHub();
        this.linkedin = obj.getLinkedin();
        this.endereco = obj.getEndereco();
        this.contato = obj.getContato();
    }
}
