package com.msinfo.mapper.relationentities.repartomedico;

import com.msinfo.dto.RepartoInfermiereDto;
import com.msinfo.entity.relantionentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoMedicoEntityMapper {
    RepartoMedicoEntityMapper INSTANCE = Mappers.getMapper(RepartoMedicoEntityMapper.class);

    RepartoMedico toEntity(RepartoInfermiereDto entity);
    List<RepartoMedico> toEntity(List<RepartoInfermiereDto> entity);
}
