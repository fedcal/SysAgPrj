package com.mspaziente.mapper.relationentities.repartomedico;

import com.mspaziente.dto.relationentities.RepartoMedicoDto;
import com.mspaziente.entity.relationentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoMedicoEntityMapper {
    RepartoMedicoEntityMapper INSTANCE = Mappers.getMapper(RepartoMedicoEntityMapper.class);

    RepartoMedico toEntity(RepartoMedicoDto dto);
    List<RepartoMedico> toEntity(List<RepartoMedicoDto> dto);
}
