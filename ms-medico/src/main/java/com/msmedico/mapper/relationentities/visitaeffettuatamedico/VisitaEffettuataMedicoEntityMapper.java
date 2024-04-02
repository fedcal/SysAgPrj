package com.msmedico.mapper.relationentities.visitaeffettuatamedico;

import com.msmedico.dto.relationentities.VisitaEffettuataMedicoDto;
import com.msmedico.entity.relationentities.VisitaEffettuataMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaEffettuataMedicoEntityMapper {
    VisitaEffettuataMedicoEntityMapper INSTANCE = Mappers.getMapper(VisitaEffettuataMedicoEntityMapper.class);

    VisitaEffettuataMedico toEntity(VisitaEffettuataMedicoDto dto);
    List<VisitaEffettuataMedico> toEntity(List<VisitaEffettuataMedicoDto> dtos);
}
