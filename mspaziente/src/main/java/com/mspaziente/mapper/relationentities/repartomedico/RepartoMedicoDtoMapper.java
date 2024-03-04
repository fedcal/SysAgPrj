package com.mspaziente.mapper.relationentities.repartomedico;

import com.mspaziente.dto.relationentities.RepartoMedicoDto;
import com.mspaziente.entity.relationentities.RepartoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepartoMedicoDtoMapper {
    RepartoMedicoDtoMapper INSTANCE = Mappers.getMapper(RepartoMedicoDtoMapper.class);

    RepartoMedicoDto toDto(RepartoMedico entity);
    List<RepartoMedicoDto> toDto(List<RepartoMedico> entity);
}
