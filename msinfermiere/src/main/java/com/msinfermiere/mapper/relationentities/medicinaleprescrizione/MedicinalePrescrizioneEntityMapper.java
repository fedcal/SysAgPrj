package com.msinfermiere.mapper.relationentities.medicinaleprescrizione;

import com.msinfermiere.dto.relationentities.MedicinalePrescrizioneDto;
import com.msinfermiere.entity.relationentites.MedicinalePrescrizione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinalePrescrizioneEntityMapper {
    MedicinalePrescrizioneEntityMapper INSTANCE = Mappers.getMapper(MedicinalePrescrizioneEntityMapper.class);

    MedicinalePrescrizione toEntity(MedicinalePrescrizioneDto entity);
    List<MedicinalePrescrizione> toEntity(List<MedicinalePrescrizioneDto> entity);
}
