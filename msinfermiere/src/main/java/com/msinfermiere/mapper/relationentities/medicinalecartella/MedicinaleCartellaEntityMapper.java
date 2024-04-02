package com.msinfermiere.mapper.relationentities.medicinalecartella;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleCartellaEntityMapper {
    MedicinaleCartellaEntityMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaEntityMapper.class);

    Medicinale toEntity(MedicinaleDto dto);
    List<Medicinale> toEntity(List<MedicinaleDto> dto);
}
