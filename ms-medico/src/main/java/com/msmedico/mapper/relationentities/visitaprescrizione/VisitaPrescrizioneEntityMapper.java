package com.msmedico.mapper.relationentities.visitaprescrizione;

import com.msmedico.dto.relationentities.VisitaPrescrizioneDto;
import com.msmedico.entity.relationentities.VisitaPrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaPrescrizioneEntityMapper {
    VisitaPrescrizioneEntityMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneEntityMapper.class);

    VisitaPrescrizione toEntity(VisitaPrescrizioneDto dto);
    List<VisitaPrescrizione> toEntity(List<VisitaPrescrizioneDto> dtos);
}
