package com.msinfermiere.mapper.relationentities.visitasottoministrzioneinfermiere;

import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneInfermiereEntityMapper {
    VisitaSottoministrazioneInfermiereEntityMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneInfermiereEntityMapper.class);

    VisitaSottoministrazioneInfermiere toEntity(VisitaSottoministrazioneInfermiereDto dto);
    List<VisitaSottoministrazioneInfermiere> toEntity(List<VisitaSottoministrazioneInfermiereDto> dto);
}
