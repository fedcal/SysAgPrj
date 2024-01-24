package com.msmedico.mapper.relationentities.operazionecartella;

import com.msmedico.dto.relationentities.OperazioneCartellaDto;
import com.msmedico.entity.relationentities.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneCartellaEntityMapper {
    OperazioneCartellaEntityMapper INSTANCE = Mappers.getMapper(OperazioneCartellaEntityMapper.class);

    OperazioneCartella toEntity(OperazioneCartellaDto dto);
    List<OperazioneCartella> toEntity(List<OperazioneCartellaDto> dtos);
}
