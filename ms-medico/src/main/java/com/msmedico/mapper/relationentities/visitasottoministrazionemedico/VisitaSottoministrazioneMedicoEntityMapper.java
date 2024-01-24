package com.msmedico.mapper.relationentities.visitasottoministrazionemedico;

import com.msmedico.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import com.msmedico.entity.relationentities.VisitaSottoministrazioneMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneMedicoEntityMapper {
    VisitaSottoministrazioneMedicoEntityMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneMedicoEntityMapper.class);

    VisitaSottoministrazioneMedico toEntity(VisitaSottoministrazioneMedicoDto dto);
    List<VisitaSottoministrazioneMedico> toEntity(List<VisitaSottoministrazioneMedicoDto> dtos);
}
