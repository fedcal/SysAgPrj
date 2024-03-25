package com.msinfermiere.mapper.relationentities.visitaeffettuatamedico;

import com.msinfermiere.dto.relationentities.VisitaEffettuataMedicoDto;
import com.msinfermiere.entity.relationentites.VisitaEffettuataMedico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaEffettuataMedicoEntityMapper {
    VisitaEffettuataMedicoEntityMapper INSTANCE = Mappers.getMapper(VisitaEffettuataMedicoEntityMapper.class);

    VisitaEffettuataMedico toEntity(VisitaEffettuataMedicoDto dto);
    List<VisitaEffettuataMedico> toEntity(List<VisitaEffettuataMedicoDto> dto);
}
