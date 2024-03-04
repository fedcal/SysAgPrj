package com.mspaziente.mapper.diagnosi;

import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.entity.Diagnosi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiagnosiEntityMapper {
    DiagnosiEntityMapper INSTANCE = Mappers.getMapper(DiagnosiEntityMapper.class);

    Diagnosi toEntity(DiagnosiDto dto);
    List<Diagnosi> toEntity(List<DiagnosiDto> dto);
}
