package com.mspaziente.mapper.paziente;

import com.mspaziente.dto.PazienteDto;
import com.mspaziente.entity.Paziente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PazienteEntityMapper {
    PazienteEntityMapper INSTANCE = Mappers.getMapper(PazienteEntityMapper.class);
    Paziente toEntity(PazienteDto dto);
    List<Paziente> toEntity(List<PazienteDto> dto);
}
