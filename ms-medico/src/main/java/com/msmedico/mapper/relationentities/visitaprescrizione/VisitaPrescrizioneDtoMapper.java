package com.msmedico.mapper.relationentities.visitaprescrizione;

import com.msmedico.dto.relationentities.VisitaPrescrizioneDto;
import com.msmedico.entity.relationentities.VisitaPrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaPrescrizioneDtoMapper {
    VisitaPrescrizioneDtoMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneDtoMapper.class);

    VisitaPrescrizioneDto toDto(VisitaPrescrizione entity);
    List<VisitaPrescrizioneDto> toDto(List<VisitaPrescrizione> entities);
}
