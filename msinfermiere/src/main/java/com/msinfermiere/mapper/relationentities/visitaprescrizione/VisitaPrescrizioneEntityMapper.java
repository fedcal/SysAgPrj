package com.msinfermiere.mapper.relationentities.visitaprescrizione;

import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface VisitaPrescrizioneEntityMapper {
    VisitaPrescrizioneEntityMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneEntityMapper.class);

    VisitaPrescrizione toDto(VisitaPrescrizioneDto entity);
    List<VisitaPrescrizione> toDto(List<VisitaPrescrizioneDto> entity);
}
