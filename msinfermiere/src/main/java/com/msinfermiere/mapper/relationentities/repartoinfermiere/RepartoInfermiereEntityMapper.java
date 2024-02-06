package com.msinfermiere.mapper.relationentities.repartoinfermiere;

import com.msinfermiere.dto.relationentities.RepartoInfermiereDto;
import com.msinfermiere.entity.relationentites.RepartoInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoInfermiereEntityMapper {
    RepartoInfermiereEntityMapper INSTANCE = Mappers.getMapper(RepartoInfermiereEntityMapper.class);

    RepartoInfermiere toEntity(RepartoInfermiereDto dto);
    List<RepartoInfermiere> toEntity(List<RepartoInfermiereDto> dto);
}
