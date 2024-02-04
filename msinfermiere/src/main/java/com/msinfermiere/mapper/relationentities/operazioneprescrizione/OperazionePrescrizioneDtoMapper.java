package com.msinfermiere.mapper.relationentities.operazioneprescrizione;

import com.msinfermiere.dto.relationentities.OperazionePrescrizioneDto;
import com.msinfermiere.entity.relationentites.OperazionePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazionePrescrizioneDtoMapper {
    OperazionePrescrizioneDtoMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneDtoMapper.class);

    OperazionePrescrizioneDto toDto(OperazionePrescrizione entity);
    List<OperazionePrescrizioneDto> toDto(List<OperazionePrescrizione> entity);
}
