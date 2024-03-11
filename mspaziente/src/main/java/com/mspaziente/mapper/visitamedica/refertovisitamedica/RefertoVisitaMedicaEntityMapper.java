package com.mspaziente.mapper.visitamedica.refertovisitamedica;

import com.mspaziente.dto.visitamedica.RefertoVisitaMedicaDto;
import com.mspaziente.entity.visitamedica.RefertoVisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoVisitaMedicaEntityMapper {
    RefertoVisitaMedicaEntityMapper INSTANCE = Mappers.getMapper(RefertoVisitaMedicaEntityMapper.class);

    RefertoVisitaMedica toEntity(RefertoVisitaMedicaDto dto);
    List<RefertoVisitaMedica> toEntity(List<RefertoVisitaMedicaDto> dto);
}
