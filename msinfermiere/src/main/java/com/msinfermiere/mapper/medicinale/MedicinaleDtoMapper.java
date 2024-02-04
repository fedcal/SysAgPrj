package com.msinfermiere.mapper.medicinale;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleDtoMapper {
    MedicinaleDtoMapper INSTANCE = Mappers.getMapper(MedicinaleDtoMapper.class);

    MedicinaleDto toDto(Medicinale entity);
    List<MedicinaleDto> toDto(List<Medicinale> entity);
}
