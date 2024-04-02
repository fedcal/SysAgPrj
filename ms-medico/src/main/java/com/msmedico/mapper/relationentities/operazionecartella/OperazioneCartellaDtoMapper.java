package com.msmedico.mapper.relationentities.operazionecartella;

import com.msmedico.dto.relationentities.OperazioneCartellaDto;
import com.msmedico.entity.relationentities.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperazioneCartellaDtoMapper {
    OperazioneCartellaDtoMapper INSTANCE = Mappers.getMapper(OperazioneCartellaDtoMapper.class);

    OperazioneCartellaDto toDto(OperazioneCartella entity);
    List<OperazioneCartellaDto> toDto(List<OperazioneCartella> entities);
}
