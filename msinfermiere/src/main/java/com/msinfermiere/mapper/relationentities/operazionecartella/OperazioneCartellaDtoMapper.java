package com.msinfermiere.mapper.relationentities.operazionecartella;

import com.msinfermiere.dto.relationentities.OperazioneCartellaDto;
import com.msinfermiere.entity.relationentites.OperazioneCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperazioneCartellaDtoMapper {
    OperazioneCartellaDtoMapper INSTANCE = Mappers.getMapper(OperazioneCartellaDtoMapper.class);

    OperazioneCartellaDto toDto(OperazioneCartella entity);
    List<OperazioneCartellaDto> toDto(List<OperazioneCartella> entity);
}
