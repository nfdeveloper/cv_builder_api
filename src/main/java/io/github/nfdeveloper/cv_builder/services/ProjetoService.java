package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.models.Projeto;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.ProjetoRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;
    @Autowired
    private ExperienciaService experienciaService;

    //Recupera Usuário logado.
    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }
    
    public List<ProjetoResponseDTO> listar(HttpServletRequest request){
        return repository.findByUsuario(getUsuario(request))
                .stream()
                .map(p -> new ProjetoResponseDTO(p))
                .toList();
    }

    @Transactional
    public ProjetoResponseDTO criar(ProjetoCreateDTO dto, HttpServletRequest request){
        Projeto projeto = new Projeto(dto);
        projeto.defineUsuario(getUsuario(request));
        projeto.defineExperiencia(experienciaService.buscarPorId(dto.getExperienciaId()));
        return new ProjetoResponseDTO(repository.save(projeto));
    }
}
