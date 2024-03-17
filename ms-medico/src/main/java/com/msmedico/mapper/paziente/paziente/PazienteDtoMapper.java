package com.msmedico.mapper.paziente.paziente;

import com.msmedico.dto.paziente.PazienteDto;
import com.msmedico.entity.paziente.Paziente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PazienteDtoMapper {
    PazienteDtoMapper INSTANCE = Mappers.getMapper(PazienteDtoMapper.class);

    PazienteDto toDto(Paziente entity);
    List<PazienteDto> toDto(List<Paziente> entities);
}
