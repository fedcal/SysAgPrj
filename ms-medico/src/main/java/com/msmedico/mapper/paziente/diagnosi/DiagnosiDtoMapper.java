package com.msmedico.mapper.paziente.diagnosi;

import com.msmedico.dto.paziente.DiagnosiDto;
import com.msmedico.entity.paziente.Diagnosi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiagnosiDtoMapper {
    DiagnosiDtoMapper INSTANCE = Mappers.getMapper(DiagnosiDtoMapper.class);

    DiagnosiDto toDto(Diagnosi entity);
    List<DiagnosiDto> toDto(List<Diagnosi> entities);
}
