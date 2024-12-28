package io.github.nfdeveloper.cv_builder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoResponseDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.mappers.CurriculoMapper;
import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;
import io.github.nfdeveloper.cv_builder.entities.models.Curso;
import io.github.nfdeveloper.cv_builder.entities.models.Experiencia;
import io.github.nfdeveloper.cv_builder.entities.models.Usuario;
import io.github.nfdeveloper.cv_builder.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.cv_builder.repositories.CurriculoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private ExperienciaService experienciaService;

    public List<CurriculoResponseDTO> listar(HttpServletRequest request) {
        return CurriculoMapper.toListDTO(repository.findByUsuario(getUsuario(request)));
    }

    @Transactional
    public CurriculoResponseDTO criar(CurriculoCreateDTO dto, HttpServletRequest request) {
        Curriculo curriculo = CurriculoMapper.toCurriculo(dto);
        curriculo.defineUsuario(getUsuario(request));
        if(!dto.getCursos().isEmpty()){
            curriculo.defineCursos(recuperaCursos(dto.getCursos()));
        }
        if(!dto.getExperiencias().isEmpty()){
            curriculo.defineExperiencias(recuperaExperiencias(dto.getExperiencias()));
        }
        return CurriculoMapper.toDto(repository.save(curriculo));
    }

    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }

    private List<Curso> recuperaCursos(List<Long> ids){
        List<Curso> cursos = new ArrayList();

        ids.stream().forEach(i -> cursos.add(cursoService.buscarPorId(i)));
        return cursos;
    }

    private List<Experiencia> recuperaExperiencias(List<Long> ids){
        List<Experiencia> experiencias = new ArrayList();

        ids.stream().forEach(i -> experiencias.add(experienciaService.buscarPorId(i)));
        return experiencias;
    }
}
