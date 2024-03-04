package com.mspaziente.mapper.relationentities.operazionecartella;

import com.mspaziente.dto.relationentities.OperazioneCartellaDto;
import com.mspaziente.entity.relationentities.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneCartellaDtoMapper {
    OperazioneCartellaDtoMapper INSTANCE = Mappers.getMapper(OperazioneCartellaDtoMapper.class);

    OperazioneCartellaDto toDto(OperazioneCartella entity);
    List<OperazioneCartellaDto> toDto(List<OperazioneCartella> entity);
}
