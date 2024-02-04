package com.msinfermiere.mapper.relationentities.operazioneprescrizione;

import com.msinfermiere.dto.relationentities.OperazionePrescrizioneDto;
import com.msinfermiere.entity.relationentites.OperazionePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazionePrescrizioneEntityMapper {
    OperazionePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneEntityMapper.class);

    OperazionePrescrizione toDto(OperazionePrescrizioneDto entity);
    List<OperazionePrescrizione> toDto(List<OperazionePrescrizioneDto> entity);
}
