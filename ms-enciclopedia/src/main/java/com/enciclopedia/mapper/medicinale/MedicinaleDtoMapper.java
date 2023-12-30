package com.enciclopedia.mapper.medicinale;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleDtoMapper {
    MedicinaleDtoMapper INSTANCE = Mappers.getMapper( MedicinaleDtoMapper.class );

    MedicinaleDto toDto(Medicinale dto);
    List<MedicinaleDto> toDto(List<Medicinale> dto);
}
