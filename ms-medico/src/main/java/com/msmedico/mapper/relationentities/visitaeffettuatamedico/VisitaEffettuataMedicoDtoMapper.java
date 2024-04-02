package com.msmedico.mapper.relationentities.visitaeffettuatamedico;

import com.msmedico.dto.relationentities.VisitaEffettuataMedicoDto;
import com.msmedico.entity.relationentities.VisitaEffettuataMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaEffettuataMedicoDtoMapper {
    VisitaEffettuataMedicoDtoMapper INSTANCE = Mappers.getMapper(VisitaEffettuataMedicoDtoMapper.class);

    VisitaEffettuataMedicoDto toDto(VisitaEffettuataMedico entity);
    List<VisitaEffettuataMedicoDto> toDto(List<VisitaEffettuataMedico> entities);
}
