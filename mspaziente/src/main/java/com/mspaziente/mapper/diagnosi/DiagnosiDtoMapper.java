package com.mspaziente.mapper.diagnosi;

import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.entity.Diagnosi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiagnosiDtoMapper {
    DiagnosiDtoMapper INSTANCE = Mappers.getMapper(DiagnosiDtoMapper.class);

    DiagnosiDto toDto(Diagnosi entity);
    List<DiagnosiDto> toDto(List<Diagnosi> entity);
}
