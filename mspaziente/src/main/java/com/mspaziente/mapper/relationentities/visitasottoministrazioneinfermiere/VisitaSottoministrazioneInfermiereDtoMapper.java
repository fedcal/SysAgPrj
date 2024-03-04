package com.mspaziente.mapper.relationentities.visitasottoministrazioneinfermiere;

import com.mspaziente.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.mspaziente.entity.relationentities.VisitaSottoministrazioneInfermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneInfermiereDtoMapper {
    VisitaSottoministrazioneInfermiereDtoMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneInfermiereDtoMapper.class);;

    VisitaSottoministrazioneInfermiereDto toDto(VisitaSottoministrazioneInfermiere entity);
    List<VisitaSottoministrazioneInfermiereDto> toDto(List<VisitaSottoministrazioneInfermiere> entity);
}
