package com.msinfermiere.mapper.relationentities.visitaeffettuatainfermiere;

import com.msinfermiere.dto.relationentities.VisitaEffettuataInfermiereDto;
import com.msinfermiere.entity.relationentites.VisitaEffettuataInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaEffettuataInfermiereEntityMapper {
    VisitaEffettuataInfermiereEntityMapper INSTANCE = Mappers.getMapper(VisitaEffettuataInfermiereEntityMapper.class);

    VisitaEffettuataInfermiere toEntity(VisitaEffettuataInfermiereDto dto);
    List<VisitaEffettuataInfermiere> toEntity(List<VisitaEffettuataInfermiereDto> dto);
}
