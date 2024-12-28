package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.application.dtos.cursos.CursoResponseDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.experiencias.ExperienciaResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.entities.models.Experiencia;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.ExperienciaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    public List<ExperienciaResponseDTO> listar(HttpServletRequest request){
        return repository.findByUsuario(getUsuario(request))
            .stream()
            .map(e -> new ExperienciaResponseDTO(e))
            .toList();
    }

    private Experiencia buscar(Long id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Experiência não encontrada.")
        );
    }

    public Experiencia buscarPorId(Long id){
        return buscar(id);
    }

    public List<ExperienciaResponseDTO> listarAtivos(HttpServletRequest request){
        return repository.findByUsuarioAndStatus(getUsuario(request), Status.ATIVO)
                .stream()
                .map(c -> new ExperienciaResponseDTO(c))
                .toList();
    }

    @Transactional
    public ExperienciaResponseDTO criar(ExperienciaCreateDTO dto, HttpServletRequest request) {
        Experiencia experiencia = new Experiencia(dto);
        experiencia.defineUsuario(getUsuario(request));
        return new ExperienciaResponseDTO(repository.save(experiencia));
    }

    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }
}
