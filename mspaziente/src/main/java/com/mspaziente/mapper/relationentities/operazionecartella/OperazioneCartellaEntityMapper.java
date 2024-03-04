package com.mspaziente.mapper.relationentities.operazionecartella;

import com.mspaziente.dto.relationentities.OperazioneCartellaDto;
import com.mspaziente.entity.relationentities.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneCartellaEntityMapper {
    OperazioneCartellaEntityMapper INSTANCE = Mappers.getMapper(OperazioneCartellaEntityMapper.class);

    OperazioneCartella toDto(OperazioneCartellaDto dto);
    List<OperazioneCartella> toDto(List<OperazioneCartellaDto> dto);
}
