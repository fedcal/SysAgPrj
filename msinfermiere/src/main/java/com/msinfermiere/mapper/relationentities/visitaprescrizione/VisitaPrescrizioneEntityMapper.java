package com.msinfermiere.mapper.relationentities.visitaprescrizione;

import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaPrescrizioneEntityMapper {
    VisitaPrescrizioneEntityMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneEntityMapper.class);

    VisitaPrescrizione toDto(VisitaPrescrizioneDto entity);
    List<VisitaPrescrizione> toDto(List<VisitaPrescrizioneDto> entity);
}
