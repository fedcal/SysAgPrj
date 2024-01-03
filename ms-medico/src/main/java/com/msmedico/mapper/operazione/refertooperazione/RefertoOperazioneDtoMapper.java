package com.msmedico.mapper.operazione.refertooperazione;

import com.msmedico.dto.operazione.RefertoOperazioneDto;
import com.msmedico.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoOperazioneDtoMapper {
    RefertoOperazioneDtoMapper INSTANCE = Mappers.getMapper(RefertoOperazioneDtoMapper.class);

    RefertoOperazioneDto toDto(RefertoOperazione entity);
    List<RefertoOperazioneDto> toDto(List<RefertoOperazione> entities);
}
