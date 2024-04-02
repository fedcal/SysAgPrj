package com.msmedico.mapper.relationentities.operazioneconsentita;

import com.msmedico.dto.relationentities.OperazioneConsentitaDto;
import com.msmedico.entity.relationentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneConsentitaEntityMapper {
    OperazioneConsentitaEntityMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaEntityMapper.class);

    OperazioneConsentita toEntity(OperazioneConsentitaDto dto);
    List<OperazioneConsentita> toEntity(List<OperazioneConsentitaDto> dtos);
}
