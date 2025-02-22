package io.github.nfdeveloper.cv_builder.jwt;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import io.github.nfdeveloper.cv_builder.entities.models.Usuario;

public class JwtUserDetails extends User{

    private Usuario usuario;

    public JwtUserDetails(Usuario usuario) {
        super(usuario.getUsername(), usuario.getPassword(), AuthorityUtils.createAuthorityList(usuario.getPermissao().name()));
        this.usuario = usuario;
    }

    public Long getId(){
        return this.usuario.getId();
    }

    public String getRole(){
        return this.usuario.getPermissao().name();
    }

}
