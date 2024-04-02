package com.msinfermiere.mapper.relationentities.medicinalecartella;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.dto.relationentities.MedicinaleCartellaDto;
import com.msinfermiere.entity.Medicinale;
import com.msinfermiere.entity.relationentites.MedicinaleCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleCartellaDtoMapper {
    MedicinaleCartellaDtoMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaDtoMapper.class);

    MedicinaleCartellaDto toDto(MedicinaleCartella dto);
    List<MedicinaleCartellaDto> toDto(List<MedicinaleCartella> dto);
}
