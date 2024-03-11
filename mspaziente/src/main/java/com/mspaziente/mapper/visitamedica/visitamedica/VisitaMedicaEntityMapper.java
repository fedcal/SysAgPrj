package com.mspaziente.mapper.visitamedica.visitamedica;

import com.mspaziente.dto.visitamedica.VisitaMedicaDto;
import com.mspaziente.entity.visitamedica.VisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaMedicaEntityMapper {
    VisitaMedicaEntityMapper INSTANCE = Mappers.getMapper(VisitaMedicaEntityMapper.class);

    VisitaMedica toEntity(VisitaMedicaDto dto);
    List<VisitaMedica> toEntity(List<VisitaMedicaDto> dto);
}
