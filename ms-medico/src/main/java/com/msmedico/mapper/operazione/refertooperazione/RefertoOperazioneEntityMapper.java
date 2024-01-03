package com.msmedico.mapper.operazione.refertooperazione;

import com.msmedico.dto.operazione.RefertoOperazioneDto;
import com.msmedico.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoOperazioneEntityMapper {
    RefertoOperazioneEntityMapper INSTANCE = Mappers.getMapper(RefertoOperazioneEntityMapper.class);

    RefertoOperazione toEntity(RefertoOperazioneDto dto);
    List<RefertoOperazione> toEntity(List<RefertoOperazioneDto> dtos);
}
