package com.msinfermiere.mapper.operazione.refertooperazione;

import com.msinfermiere.dto.operazione.RefertoOperazioneDto;
import com.msinfermiere.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoOperazioneDtoMapper {
    RefertoOperazioneDtoMapper INSTANCE = Mappers.getMapper(RefertoOperazioneDtoMapper.class);

    RefertoOperazioneDto toDto(RefertoOperazione entity);
    List<RefertoOperazione> toDto(List<RefertoOperazione> entity);
}
