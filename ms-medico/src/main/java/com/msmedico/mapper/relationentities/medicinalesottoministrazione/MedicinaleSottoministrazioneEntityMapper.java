package com.msmedico.mapper.relationentities.medicinalesottoministrazione;

import com.msmedico.entity.relationentities.MedicinaleSottoministrazione;
import com.msmedico.mspaziente.model.MedicinaleSottoministrazioneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleSottoministrazioneEntityMapper {
    MedicinaleSottoministrazioneEntityMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneEntityMapper.class);

    MedicinaleSottoministrazione toEntity(MedicinaleSottoministrazioneDto dto);
    List<MedicinaleSottoministrazione> toEntity(List<MedicinaleSottoministrazioneDto> dto);
}
