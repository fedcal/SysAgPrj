package com.mspaziente.mapper.relationentities.medicinaleprescrizione;

import com.mspaziente.dto.relationentities.MedicinalePrescrizioneDto;
import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinalePrescrizioneDtoMapper {
    MedicinalePrescrizioneDtoMapper INSTANCE = Mappers.getMapper(MedicinalePrescrizioneDtoMapper.class);

    MedicinalePrescrizioneDto toDto(MedicinalePrescrizione entity);
    List<MedicinalePrescrizioneDto> toDto(List<MedicinalePrescrizione> entity);
}
