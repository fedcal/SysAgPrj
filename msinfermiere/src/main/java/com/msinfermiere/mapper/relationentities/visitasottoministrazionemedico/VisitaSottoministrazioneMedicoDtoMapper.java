package com.msinfermiere.mapper.relationentities.visitasottoministrazionemedico;

import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaSottoministrazioneMedicoDtoMapper {
    VisitaSottoministrazioneMedicoDtoMapper INSTANCE = Mappers.getMapper(VisitaSottoministrazioneMedicoDtoMapper.class);

    VisitaSottoministrazioneMedicoDto toDto(VisitaSottoministrazioneMedico entity);
    List<VisitaSottoministrazioneMedicoDto> toDto(List<VisitaSottoministrazioneMedico> entity);
}
