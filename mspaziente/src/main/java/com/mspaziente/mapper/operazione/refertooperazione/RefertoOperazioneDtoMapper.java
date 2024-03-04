package com.mspaziente.mapper.operazione.refertooperazione;

import com.mspaziente.dto.operazione.RefertoOperazioneDto;
import com.mspaziente.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoOperazioneDtoMapper {
    RefertoOperazioneDtoMapper INSTANCE = Mappers.getMapper(RefertoOperazioneDtoMapper.class);

    RefertoOperazioneDto toDto(RefertoOperazione entity);
    List<RefertoOperazioneDto> toDto(List<RefertoOperazione> entity);
}
