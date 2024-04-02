package com.msinfermiere.mapper.relationentities.operazioneconsentita;

import com.msinfermiere.dto.relationentities.OperazioneCartellaDto;
import com.msinfermiere.entity.relationentites.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneConsentitaEntityMapper {
    OperazioneConsentitaEntityMapper INSTANCE = Mappers.getMapper(OperazioneConsentitaEntityMapper.class);

    OperazioneCartella toDto(OperazioneCartellaDto entity);
    List<OperazioneCartella> toDto(List<OperazioneCartellaDto> entity);
}
