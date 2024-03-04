package com.mspaziente.mapper.operazione.refertooperazione;

import com.mspaziente.dto.operazione.RefertoOperazioneDto;
import com.mspaziente.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefertoOperazioneEntityMapper {
    RefertoOperazioneEntityMapper INSTANCE = Mappers.getMapper(RefertoOperazioneEntityMapper.class);

    RefertoOperazione toEntity(RefertoOperazioneDto dto);
    List<RefertoOperazione> toEntity(List<RefertoOperazioneDto> dto);
}
