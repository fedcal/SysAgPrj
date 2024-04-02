package com.msmedico.mapper.medicinale;

import com.msmedico.dto.MedicinaleDto;
import com.msmedico.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleDtoMapper {
    MedicinaleDtoMapper INSTANCE = Mappers.getMapper( MedicinaleDtoMapper.class );

    MedicinaleDto toDto(Medicinale entity);
    List<MedicinaleDto> toDto(List<Medicinale> entities);
}
