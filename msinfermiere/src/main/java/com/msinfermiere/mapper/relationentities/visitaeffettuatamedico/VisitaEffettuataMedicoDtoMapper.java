package com.msinfermiere.mapper.relationentities.visitaeffettuatamedico;

import com.msinfermiere.dto.relationentities.VisitaEffettuataMedicoDto;
import com.msinfermiere.entity.relationentites.VisitaEffettuataMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaEffettuataMedicoDtoMapper {
    VisitaEffettuataMedicoDtoMapper INSTANCE = Mappers.getMapper(VisitaEffettuataMedicoDtoMapper.class);

    VisitaEffettuataMedicoDto toDto(VisitaEffettuataMedico entity);
    List<VisitaEffettuataMedicoDto> toDto(List<VisitaEffettuataMedico> entity);
}
