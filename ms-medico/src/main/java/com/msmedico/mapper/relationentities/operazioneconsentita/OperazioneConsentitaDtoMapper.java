package com.msmedico.mapper.relationentities.operazioneconsentita;

import com.msmedico.dto.relationentities.OperazioneConsentitaDto;
import com.msmedico.entity.relationentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneConsentitaDtoMapper {
    OperazioneConsentitaDtoMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaDtoMapper.class);

    OperazioneConsentitaDto toDto(OperazioneConsentita entity);
    List<OperazioneConsentitaDto> toDto(List<OperazioneConsentita> entities);
}
