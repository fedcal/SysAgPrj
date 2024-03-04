package com.mspaziente.mapper.relationentities.visitaprescrizione;

import com.mspaziente.entity.relationentities.VisitaPrescrizione;
import com.mspaziente.msmedico.model.VisitaPrescrizioneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitaPrescrizioneEntityMapper {
    VisitaPrescrizioneEntityMapper INSTANCE = Mappers.getMapper(VisitaPrescrizioneEntityMapper.class);

    VisitaPrescrizione toEntity(VisitaPrescrizioneDto dto);
    List<VisitaPrescrizione> toEntity(List<VisitaPrescrizioneDto> dto);
}
