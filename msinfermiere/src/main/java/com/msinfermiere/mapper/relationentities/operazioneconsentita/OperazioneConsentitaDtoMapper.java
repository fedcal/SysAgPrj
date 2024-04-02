package com.msinfermiere.mapper.relationentities.operazioneconsentita;

import com.msinfermiere.dto.relationentities.OperazioneCartellaDto;
import com.msinfermiere.entity.relationentites.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneConsentitaDtoMapper {
    OperazioneConsentitaDtoMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaDtoMapper.class);

    OperazioneCartellaDto toDto(OperazioneCartella entity);
    List<OperazioneCartellaDto> toDto(List<OperazioneCartella> entity);
}
