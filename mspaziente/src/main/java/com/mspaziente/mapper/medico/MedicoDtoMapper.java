package com.mspaziente.mapper.medico;

import com.mspaziente.dto.MedicoDto;
import com.mspaziente.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicoDtoMapper {
    MedicoDtoMapper INSTANCE = Mappers.getMapper(MedicoDtoMapper.class);
    MedicoDto toDto(Medico medico);
    List<MedicoDto> toDto(List<Medico> medico);
}
