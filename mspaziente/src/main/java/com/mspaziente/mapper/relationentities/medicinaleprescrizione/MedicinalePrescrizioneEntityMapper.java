package com.mspaziente.mapper.relationentities.medicinaleprescrizione;

import com.mspaziente.dto.relationentities.MedicinalePrescrizioneDto;
import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinalePrescrizioneEntityMapper {
    MedicinalePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(MedicinalePrescrizioneEntityMapper.class);

    MedicinalePrescrizione toEntity(MedicinalePrescrizioneDto dto);
    List<MedicinalePrescrizione> toEntity(List<MedicinalePrescrizioneDto> dto);
}
