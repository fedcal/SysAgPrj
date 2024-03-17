package com.msmedico.mapper.relationentities.medicinalesottoministrazione;

import com.msmedico.entity.relationentities.MedicinaleSottoministrazione;
import com.msmedico.mspaziente.model.MedicinaleSottoministrazioneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleSottoministrazioneDtoMapper {
    MedicinaleSottoministrazioneDtoMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneDtoMapper.class);

    MedicinaleSottoministrazioneDto toDto(MedicinaleSottoministrazione entity);
    List<MedicinaleSottoministrazioneDto> toDto(List<MedicinaleSottoministrazione> entity);
}
