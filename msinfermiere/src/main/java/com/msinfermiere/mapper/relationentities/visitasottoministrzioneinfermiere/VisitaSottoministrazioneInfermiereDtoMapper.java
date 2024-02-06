package com.msinfermiere.mapper.relationentities.visitasottoministrzioneinfermiere;

import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneInfermiereDtoMapper {
    VisitaSottoministrazioneInfermiereDtoMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneInfermiereDtoMapper.class);

    VisitaSottoministrazioneInfermiereDto toDto(VisitaSottoministrazioneInfermiere entity);
    List<VisitaSottoministrazioneInfermiereDto> toDto(List<VisitaSottoministrazioneInfermiere> entity);
}
