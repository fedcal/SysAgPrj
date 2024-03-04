package com.mspaziente.mapper.relationentities.medicinalesottoministrazione;

import com.mspaziente.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.mspaziente.entity.relationentities.MedicinaleSottoministrazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleSottoministrazioneDtoMapper {
    MedicinaleSottoministrazioneDtoMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneDtoMapper.class);

    MedicinaleSottoministrazioneDto toDto(MedicinaleSottoministrazione entity);
    List<MedicinaleSottoministrazioneDto> toDto(List<MedicinaleSottoministrazione> entity);
}
