package com.mspaziente.mapper.relationentities.visitasottoministrazioneinfermiere;

import com.mspaziente.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.mspaziente.entity.relationentities.VisitaSottoministrazioneInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneInfermiereEntityMapper {
    VisitaSottoministrazioneInfermiereEntityMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneInfermiereEntityMapper.class);

    VisitaSottoministrazioneInfermiere toEntity(VisitaSottoministrazioneInfermiereDto dto);
    List<VisitaSottoministrazioneInfermiere> toEntity(List<VisitaSottoministrazioneInfermiereDto> dto);
}
