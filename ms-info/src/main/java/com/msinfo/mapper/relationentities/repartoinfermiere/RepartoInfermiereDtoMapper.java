package com.msinfo.mapper.relationentities.repartoinfermiere;

import com.msinfo.dto.RepartoInfermiereDto;
import com.msinfo.entity.relantionentities.RepartoInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoInfermiereDtoMapper {
    RepartoInfermiereDtoMapper INSTANCE = Mappers.getMapper(RepartoInfermiereDtoMapper.class);

    RepartoInfermiereDto toDto(RepartoInfermiere entity);
    List<RepartoInfermiereDto> toDto(List<RepartoInfermiere> entity);
}
