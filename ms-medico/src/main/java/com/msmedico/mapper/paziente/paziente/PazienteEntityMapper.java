package com.msmedico.mapper.paziente.paziente;

import com.msmedico.dto.paziente.PazienteDto;
import com.msmedico.entity.paziente.Paziente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PazienteEntityMapper {
    PazienteEntityMapper INSTANCE = Mappers.getMapper(PazienteEntityMapper.class);

    Paziente toEntity(PazienteDto dto);
    List<Paziente> toEntity(List<PazienteDto> dtos);
}
