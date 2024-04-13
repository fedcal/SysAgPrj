package com.msinfo.mapper.relationentities.operazioneconsentita;

import com.msinfo.dto.OperazioneConsentitaDto;
import com.msinfo.entity.relantionentities.OperazioneConsentita;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneConsentitaEntityMapper {
    OperazioneConsentitaEntityMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaEntityMapper.class);

    OperazioneConsentita toEntity (OperazioneConsentitaDto dto);
    List<OperazioneConsentita> toEntity (List<OperazioneConsentitaDto> dto);
}
