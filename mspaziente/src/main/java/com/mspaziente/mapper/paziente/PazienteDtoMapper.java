package com.mspaziente.mapper.paziente;

import com.mspaziente.dto.PazienteDto;
import com.mspaziente.entity.Paziente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PazienteDtoMapper {
    PazienteDtoMapper INSTANCE = Mappers.getMapper(PazienteDtoMapper.class);

    PazienteDto toDto(Paziente entity);
    List<PazienteDto> toDto(List<Paziente> entity);
}
