package com.msinfermiere.mapper.relationentities.visitasottoministrazionemedico;

import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneMedicoEntityMapper {
    VisitaSottoministrazioneMedicoEntityMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneMedicoEntityMapper.class);

    VisitaSottoministrazioneMedico toEntity(VisitaSottoministrazioneMedicoDto dto);
    List<VisitaSottoministrazioneMedico> toEntity(List<VisitaSottoministrazioneMedicoDto> dto);
}
