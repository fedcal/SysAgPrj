package com.msmedico.mapper.relationentities.repartomedico;

import com.msmedico.dto.relationentities.RepartoMedicoDto;
import com.msmedico.entity.relationentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepartoMedicoEntityMapper {
    RepartoMedicoEntityMapper INSTANCE = Mappers.getMapper(RepartoMedicoEntityMapper.class);

    RepartoMedico toEntity(RepartoMedicoDto dto);
    List<RepartoMedico> toEntity(List<RepartoMedicoDto> dtos);
}
