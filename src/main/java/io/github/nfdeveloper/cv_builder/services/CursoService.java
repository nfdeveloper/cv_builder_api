package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.application.dtos.cursos.CursoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.cursos.CursoResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.enums.Status;
import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.CursoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    public List<CursoResponseDTO> listar(HttpServletRequest request){
        return repository.findByUsuario(getUsuario(request))
                .stream()
                .map(c -> new CursoResponseDTO(c))
                .toList();
    }

    private Curso buscar(Long id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Curso não encontrado.")
        );
    }

    public Curso buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public CursoResponseDTO criar(CursoCreateDTO dto, HttpServletRequest request) {
        Curso curso = new Curso(dto);
        curso.defineUsuario(getUsuario(request));
        return new CursoResponseDTO(repository.save(curso));
    }

    public List<CursoResponseDTO> listarAtivos(HttpServletRequest request){
        return repository.findByUsuarioAndStatus(getUsuario(request), Status.ATIVO)
                .stream()
                .map(c -> new CursoResponseDTO(c))
                .toList();
    }

    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }
}
