package com.msinfermiere.mapper.operazione.refertooperazione;

import com.msinfermiere.dto.operazione.RefertoOperazioneDto;
import com.msinfermiere.entity.operazione.RefertoOperazione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefertoOperazioneEntityMapper {
    RefertoOperazioneEntityMapper INSTANCE = Mappers.getMapper(RefertoOperazioneEntityMapper.class);

    RefertoOperazione toDto(RefertoOperazioneDto dto);
    List<RefertoOperazione> toDto(List<RefertoOperazioneDto> dto);
}
