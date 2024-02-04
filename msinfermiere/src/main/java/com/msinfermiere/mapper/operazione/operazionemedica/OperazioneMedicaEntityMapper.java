package com.msinfermiere.mapper.operazione.operazionemedica;

import com.msinfermiere.dto.operazione.OperazioneMedicaDto;
import com.msinfermiere.entity.operazione.OperazioneMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneMedicaEntityMapper {
    OperazioneMedicaEntityMapper INSTANCE = Mappers.getMapper(OperazioneMedicaEntityMapper.class);

    OperazioneMedica toEntity(OperazioneMedicaDto dto);
    List<OperazioneMedica> toEntity(List<OperazioneMedicaDto> dto);
}
