package com.msinfo.mapper.relationentities.repartoinfermiere;

import com.msinfo.dto.RepartoInfermiereDto;
import com.msinfo.entity.relantionentities.RepartoInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoInfermiereEntityMapper {
    RepartoInfermiereEntityMapper INSTANCE = Mappers.getMapper(RepartoInfermiereEntityMapper.class);

    RepartoInfermiere toEntity(RepartoInfermiereDto entity);
    List<RepartoInfermiere> toEntity(List<RepartoInfermiereDto> entity);
}
