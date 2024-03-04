package com.mspaziente.mapper.medicinale;

import com.mspaziente.dto.MedicinaleDto;
import com.mspaziente.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleDtoMapper {
    MedicinaleDtoMapper INSTANCE = Mappers.getMapper(MedicinaleDtoMapper.class);

    MedicinaleDto toDto(Medicinale entity);
    List<MedicinaleDto> toDto(List<Medicinale> entity);
}
