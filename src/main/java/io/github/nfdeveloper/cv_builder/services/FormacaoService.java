package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nfdeveloper.cv_builder.application.dtos.formacoes.FormacaoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.formacoes.FormacaoResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.models.Formacao;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.FormacaoRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class FormacaoService {

    @Autowired
    private FormacaoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    //Recupera Usuário logado.
    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }

    public List<FormacaoResponseDTO> list(HttpServletRequest request){
        return repository.findByUsuario(getUsuario(request))
                .stream()
                .map(f -> new FormacaoResponseDTO(f))
                .toList();
    }

    @Transactional
    public FormacaoResponseDTO criar(FormacaoCreateDTO dto, HttpServletRequest request){
        Formacao formacao = new Formacao(dto);
        formacao.defineUsuario(getUsuario(request));
        return new FormacaoResponseDTO(repository.save(formacao));
    }
    
}
