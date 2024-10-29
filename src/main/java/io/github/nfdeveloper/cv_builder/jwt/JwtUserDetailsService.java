package io.github.nfdeveloper.cv_builder.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.entities.enums.Role;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.services.UsuarioService;

@Service
public class JwtUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = service.buscarPorUsername(username);
        return new JwtUserDetails(usuario);
    }

    public JwtToken getTokenAuthenticated(String username){
        Role role = service.buscarRolePorUsername(username);
        return JwtUtils.createToken(username, role.name());
    }

}
