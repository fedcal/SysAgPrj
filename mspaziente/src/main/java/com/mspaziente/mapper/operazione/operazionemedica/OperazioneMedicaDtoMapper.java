package com.mspaziente.mapper.operazione.operazionemedica;

import com.mspaziente.dto.operazione.OperazioneMedicaDto;
import com.mspaziente.entity.operazione.OperazioneMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneMedicaDtoMapper {
    OperazioneMedicaDtoMapper INSTANCE = Mappers.getMapper(OperazioneMedicaDtoMapper.class);

    OperazioneMedicaDto toDto(OperazioneMedica entity);
    List<OperazioneMedicaDto> toDto(List<OperazioneMedica> entity);
}
