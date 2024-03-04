package com.mspaziente.mapper.relationentities.operazioneconsentita;

import com.mspaziente.dto.relationentities.OperazioneConsentitaDto;
import com.mspaziente.entity.relationentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneConsentitaDtoMapper {
    OperazioneConsentitaDtoMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaDtoMapper.class);

    OperazioneConsentitaDto toDto(OperazioneConsentita entity);
    List<OperazioneConsentitaDto> toDto(List<OperazioneConsentita> entity);
}
