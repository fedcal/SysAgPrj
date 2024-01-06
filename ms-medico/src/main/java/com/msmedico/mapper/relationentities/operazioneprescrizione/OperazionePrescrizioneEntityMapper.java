package com.msmedico.mapper.relationentities.operazioneprescrizione;

import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.entity.relationentities.OperazionePrescrizione;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface OperazionePrescrizioneEntityMapper {
    OperazionePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneEntityMapper.class);

    OperazionePrescrizione toDto(OperazionePrescrizioneDto entity);
    List<OperazionePrescrizione> toDto(List<OperazionePrescrizioneDto> entities);
}
