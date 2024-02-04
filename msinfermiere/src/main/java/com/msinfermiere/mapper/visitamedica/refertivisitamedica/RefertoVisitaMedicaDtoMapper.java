package com.msinfermiere.mapper.visitamedica.refertivisitamedica;

import com.msinfermiere.dto.visitamedica.RefertoVisitaMedicaDto;
import com.msinfermiere.entity.visitamedica.RefertoVisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoVisitaMedicaDtoMapper {
    RefertoVisitaMedicaDtoMapper INSTANCE = Mappers.getMapper(RefertoVisitaMedicaDtoMapper.class);

    RefertoVisitaMedicaDto toDto(RefertoVisitaMedica entity);
    List<RefertoVisitaMedicaDto> toDto(List<RefertoVisitaMedica> entity);
}
