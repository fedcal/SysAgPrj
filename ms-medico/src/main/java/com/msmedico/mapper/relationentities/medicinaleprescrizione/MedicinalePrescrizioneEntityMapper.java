package com.msmedico.mapper.relationentities.medicinaleprescrizione;

import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinalePrescrizioneEntityMapper {
    MedicinalePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(MedicinalePrescrizioneEntityMapper.class);

    MedicinalePrescrizione toEntity(MedicinalePrescrizioneDto dto);
    List<MedicinalePrescrizione> toEntity(List<MedicinalePrescrizioneDto> dtos);
}
