package com.msinfermiere.mapper.visitamedica.visitamedica;

import com.msinfermiere.dto.visitamedica.VisitaMedicaDto;
import com.msinfermiere.entity.visitamedica.VisitaMedica;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaMedicaEntityMapper {
    VisitaMedicaEntityMapper INSTANCE = Mappers.getMapper(VisitaMedicaEntityMapper.class);

    VisitaMedica toEntity(VisitaMedicaDto entity);
    List<VisitaMedica> toEntity(List<VisitaMedicaDto> entity);
}
