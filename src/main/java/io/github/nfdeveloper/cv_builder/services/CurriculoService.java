package io.github.nfdeveloper.cv_builder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoResponseDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.mappers.CurriculoMapper;
import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;
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

    public List<CurriculoResponseDTO> listar(HttpServletRequest request) {
        return CurriculoMapper.toListDTO(repository.findByUsuario(getUsuario(request)));
    }

    @Transactional
    public CurriculoResponseDTO criar(CurriculoCreateDTO dto, HttpServletRequest request) {
        Curriculo curriculo = CurriculoMapper.toCurriculo(dto);
        curriculo.defineUsuario(getUsuario(request));
        return CurriculoMapper.toDto(repository.save(curriculo));
    }

    private Usuario getUsuario(HttpServletRequest request){
        return jwtService.getUsuarioByToken(request);
    }
}
