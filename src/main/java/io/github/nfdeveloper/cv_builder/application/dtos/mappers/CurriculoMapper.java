package io.github.nfdeveloper.cv_builder.application.dtos.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;

import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoCreateDTO;
import io.github.nfdeveloper.cv_builder.application.dtos.curriculo.CurriculoResponseDTO;
import io.github.nfdeveloper.cv_builder.entities.models.Curriculo;

public class CurriculoMapper {

    public static Curriculo toCurriculo(CurriculoCreateDTO dto){
        return new ModelMapper().map(dto, Curriculo.class);
    }

    public static CurriculoResponseDTO toDto(Curriculo curriculo){
        return new ModelMapper().map(curriculo, CurriculoResponseDTO.class);
    }

    public static List<CurriculoResponseDTO> toListDTO(List<Curriculo> list){
        return list.stream()
                   .map(c -> toDto(c))
                   .toList();
    }
}
