package com.msinfermiere.mapper.relationentities.repartoinfermiere;

import com.msinfermiere.dto.relationentities.RepartoInfermiereDto;
import com.msinfermiere.entity.relationentites.RepartoInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoInfermiereDtoMapper {
    RepartoInfermiereDtoMapper INSTANCE = Mappers.getMapper(RepartoInfermiereDtoMapper.class);

    RepartoInfermiereDto toDto(RepartoInfermiere dto);
    List<RepartoInfermiereDto> toDto(List<RepartoInfermiere> dto);
}
