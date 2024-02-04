package com.msinfermiere.mapper.relationentities.medicinalesottoministrazione;

import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleSottoministrazioneDtoMapper {
    MedicinaleSottoministrazioneDtoMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneDtoMapper.class);

    MedicinaleSottoministrazioneDto toDto(MedicinaleSottoministrazione entity);
    List<MedicinaleSottoministrazioneDto> toDto(List<MedicinaleSottoministrazione> entity);
}
