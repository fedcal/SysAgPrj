package com.mspaziente.mapper.relationentities.visitasottoministrazionemedico;

import com.mspaziente.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import com.mspaziente.entity.relationentities.VisitaSottoministrazioneMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneMedicoDtoMapper {
    VisitaSottoministrazioneMedicoDtoMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneMedicoDtoMapper.class);

    VisitaSottoministrazioneMedicoDto toDto(VisitaSottoministrazioneMedico entity);
    List<VisitaSottoministrazioneMedicoDto> toDto(List<VisitaSottoministrazioneMedico> entity);
}
