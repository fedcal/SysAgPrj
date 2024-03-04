package com.mspaziente.mapper.relationentities.operazioneconsentita;

import com.mspaziente.dto.relationentities.OperazioneConsentitaDto;
import com.mspaziente.entity.relationentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneConsentitaEntityMapper {
    OperazioneConsentitaEntityMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaEntityMapper.class);

    OperazioneConsentita toEntity(OperazioneConsentitaDto dto);
    List<OperazioneConsentita> toEntity(List<OperazioneConsentitaDto> dto);
}
