package com.msinfermiere.mapper.visitamedica.refertivisitamedica;

import com.msinfermiere.dto.visitamedica.RefertoVisitaMedicaDto;
import com.msinfermiere.entity.visitamedica.RefertoVisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface RefertoVisitaMedicaEntityMapper {
    RefertoVisitaMedicaEntityMapper INSTANCE = Mappers.getMapper(RefertoVisitaMedicaEntityMapper.class);

    RefertoVisitaMedica toEntity(RefertoVisitaMedicaDto entity);
    List<RefertoVisitaMedica> toEntity(List<RefertoVisitaMedicaDto> entity);
}
