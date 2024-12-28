package io.github.nfdeveloper.cv_builder.application.dtos.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;

import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.projetos.ProjetoResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.models.Projeto;

public class ProjetoMapper {

    public static Projeto toProjeto(ProjetoCreateDTO dto){
        return new ModelMapper().map(dto, Projeto.class);
    }

    public static ProjetoResponseDTO toDto(Projeto projeto){
        return new ModelMapper().map(projeto, ProjetoResponseDTO.class);
    }

    public static List<ProjetoResponseDTO> toListDTO(List<Projeto> list){
        return list.stream()
                    .map(p -> toDto(p))
                    .toList();
    }
}
