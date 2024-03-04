package com.mspaziente.mapper.relationentities.visitaprescrizione;

import com.mspaziente.dto.relationentities.VisitaPrescrizioneDto;
import com.mspaziente.entity.relationentities.VisitaPrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaPrescrizioneDtoMapper {
    VisitaPrescrizioneDtoMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneDtoMapper.class);

    VisitaPrescrizioneDto toDto(VisitaPrescrizione entity);
    List<VisitaPrescrizioneDto> toDto(List<VisitaPrescrizione> entity);
}
