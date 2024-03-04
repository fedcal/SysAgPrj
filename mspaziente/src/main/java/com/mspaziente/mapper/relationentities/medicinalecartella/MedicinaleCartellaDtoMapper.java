package com.mspaziente.mapper.relationentities.medicinalecartella;

import com.mspaziente.dto.relationentities.MedicinaleCartellaDto;
import com.mspaziente.entity.relationentities.MedicinaleCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleCartellaDtoMapper {
    MedicinaleCartellaDtoMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaDtoMapper.class);

    MedicinaleCartellaDto toDto(MedicinaleCartella entity);
    List<MedicinaleCartellaDto> toDto(List<MedicinaleCartella> entity);
}
