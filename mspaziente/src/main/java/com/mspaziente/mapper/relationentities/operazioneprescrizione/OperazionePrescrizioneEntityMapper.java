package com.mspaziente.mapper.relationentities.operazioneprescrizione;

import com.mspaziente.dto.relationentities.OperazionePrescrizioneDto;
import com.mspaziente.entity.relationentities.OperazionePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazionePrescrizioneEntityMapper {
    OperazionePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneEntityMapper.class);

    OperazionePrescrizione toEntity(OperazionePrescrizioneDto dto);
    List<OperazionePrescrizione> toEntity(List<OperazionePrescrizioneDto> dto);
}
