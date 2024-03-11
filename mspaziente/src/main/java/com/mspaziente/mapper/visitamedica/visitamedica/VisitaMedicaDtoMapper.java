package com.mspaziente.mapper.visitamedica.visitamedica;

import com.mspaziente.dto.visitamedica.VisitaMedicaDto;
import com.mspaziente.entity.visitamedica.VisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaMedicaDtoMapper {
    VisitaMedicaDtoMapper INSTANCE = Mappers.getMapper(VisitaMedicaDtoMapper.class);

    VisitaMedicaDto toDto(VisitaMedica entity);
    List<VisitaMedicaDto> toDto(List<VisitaMedica> entity);
}
