package com.msinfo.mapper.relationentities.repartomedico;

import com.msinfo.dto.RepartoInfermiereDto;
import com.msinfo.entity.relantionentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoMedicoDtoMapper {
    RepartoMedicoDtoMapper INSTANCE = Mappers.getMapper(RepartoMedicoDtoMapper.class);
    RepartoInfermiereDto toDto(RepartoMedico entity);
    List<RepartoInfermiereDto> toDto(List<RepartoMedico> entity);

}
