package com.msinfermiere.mapper.relationentities.medicinalesottoministrazione;

import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleSottoministrazioneEntityMapper {
    MedicinaleSottoministrazioneEntityMapper INSTANCE = Mappers.getMapper(MedicinaleSottoministrazioneEntityMapper.class);

    MedicinaleSottoministrazione toEntity(MedicinaleSottoministrazioneDto enntity);
    List<MedicinaleSottoministrazione> toEntity(List<MedicinaleSottoministrazioneDto> enntity);
}
