package com.msmedico.mapper.relationentities.visitasottoministrazionemedico;

import com.msmedico.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import com.msmedico.entity.relationentities.VisitaSottoministrazioneMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneMedicoDtoMapper {
    VisitaSottoministrazioneMedicoDtoMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneMedicoDtoMapper.class);

    VisitaSottoministrazioneMedicoDto toDto(VisitaSottoministrazioneMedico entity);
    List<VisitaSottoministrazioneMedicoDto> toDto(List<VisitaSottoministrazioneMedico> entities);
}
