package com.mspaziente.mapper.relationentities.medicinalesottoministrazione;

import com.mspaziente.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.mspaziente.entity.relationentities.MedicinaleSottoministrazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleSottoministrazioneEntityMapper {
    MedicinaleSottoministrazioneEntityMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneEntityMapper.class);

    MedicinaleSottoministrazione toEntity(MedicinaleSottoministrazioneDto dto);
    List<MedicinaleSottoministrazione> toEntity(List<MedicinaleSottoministrazioneDto> dto);
}
