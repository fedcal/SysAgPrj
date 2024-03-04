package com.mspaziente.mapper.relationentities.operazioneprescrizione;

import com.mspaziente.dto.relationentities.OperazionePrescrizioneDto;
import com.mspaziente.entity.relationentities.OperazionePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazionePrescrizioneDtoMapper {
    OperazionePrescrizioneDtoMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneDtoMapper.class);

    OperazionePrescrizioneDto toDto(OperazionePrescrizione entity);
    List<OperazionePrescrizioneDto> toDto(List<OperazionePrescrizione> entity);
}
