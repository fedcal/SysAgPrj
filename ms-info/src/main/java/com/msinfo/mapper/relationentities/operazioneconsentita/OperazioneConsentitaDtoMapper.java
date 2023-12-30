package com.msinfo.mapper.relationentities.operazioneconsentita;

import com.msinfo.dto.OperazioneConsentitaDto;
import com.msinfo.entity.relantionentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneConsentitaDtoMapper {
    OperazioneConsentitaDtoMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaDtoMapper.class);

    OperazioneConsentitaDto toDto (OperazioneConsentita dto);
    List<OperazioneConsentitaDto> toDto (List<OperazioneConsentita> dto);
}
