package com.msmedico.mapper.visitamedica.visitamedica;

import com.msmedico.dto.visitamedica.VisitaMedicaDto;
import com.msmedico.entity.visitamedica.VisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaMedicaDtoMapper {
    VisitaMedicaDtoMapper INSTANCE = Mappers.getMapper(VisitaMedicaDtoMapper.class);
    VisitaMedicaDto toDto(VisitaMedica entity);
    List<VisitaMedicaDto> toDto(List<VisitaMedica> entities);
}
