package com.msmedico.mapper.relationentities.medicinaleprescrizione;

import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinalePrescrizioneDtoMapper {
    MedicinalePrescrizioneDtoMapper INSTANCE = Mappers.getMapper(MedicinalePrescrizioneDtoMapper.class);

    MedicinalePrescrizioneDto toDto(MedicinalePrescrizione entity);
    List<MedicinalePrescrizioneDto> toDto(List<MedicinalePrescrizione> entities);
}
