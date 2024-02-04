package com.msinfermiere.mapper.relationentities.medicinalecartella;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MedicinaleCartellaDtoMapper {
    MedicinaleCartellaDtoMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaDtoMapper.class);

    MedicinaleDto toDto(Medicinale dto);
    List<MedicinaleDto> toDto(List<Medicinale> dto);
}
