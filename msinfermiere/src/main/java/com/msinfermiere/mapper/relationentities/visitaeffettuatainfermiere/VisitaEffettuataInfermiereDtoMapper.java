package com.msinfermiere.mapper.relationentities.visitaeffettuatainfermiere;

import com.msinfermiere.dto.relationentities.VisitaEffettuataInfermiereDto;
import com.msinfermiere.entity.relationentites.VisitaEffettuataInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaEffettuataInfermiereDtoMapper {
    VisitaEffettuataInfermiereDtoMapper INSTANCE = Mappers.getMapper(VisitaEffettuataInfermiereDtoMapper.class);

    VisitaEffettuataInfermiereDto toDto(VisitaEffettuataInfermiere entity);
    List<VisitaEffettuataInfermiereDto> toDto(List<VisitaEffettuataInfermiere> entity);
}
