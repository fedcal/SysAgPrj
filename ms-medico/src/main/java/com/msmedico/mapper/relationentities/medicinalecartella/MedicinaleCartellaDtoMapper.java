package com.msmedico.mapper.relationentities.medicinalecartella;

import com.msmedico.dto.MedicinaleDto;
import com.msmedico.dto.relationentities.MedicinaleCartellaDto;
import com.msmedico.entity.relationentities.MedicinaleCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicinaleCartellaDtoMapper {
    MedicinaleCartellaDtoMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaDtoMapper.class);

    MedicinaleCartellaDto toDto(MedicinaleCartella entity);
    List<MedicinaleCartellaDto> toDto(List<MedicinaleCartella> entities);
}
