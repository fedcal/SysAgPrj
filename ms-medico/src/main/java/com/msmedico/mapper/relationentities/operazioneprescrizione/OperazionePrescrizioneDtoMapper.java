package com.msmedico.mapper.relationentities.operazioneprescrizione;

import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.entity.relationentities.OperazionePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazionePrescrizioneDtoMapper {
    OperazionePrescrizioneDtoMapper INSTANCE = Mappers.getMapper(OperazionePrescrizioneDtoMapper.class);

    OperazionePrescrizioneDto toDto(OperazionePrescrizione entity);
    List<OperazionePrescrizioneDto> toDto(List<OperazionePrescrizione> entities);
}
