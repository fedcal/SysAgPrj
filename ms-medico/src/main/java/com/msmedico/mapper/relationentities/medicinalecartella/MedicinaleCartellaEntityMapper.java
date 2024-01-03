package com.msmedico.mapper.relationentities.medicinalecartella;

import com.msmedico.dto.relationentities.MedicinaleCartellaDto;
import com.msmedico.entity.relationentities.MedicinaleCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleCartellaEntityMapper {
    MedicinaleCartellaEntityMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaEntityMapper.class);

    MedicinaleCartella toEntity(MedicinaleCartellaDto dto);
    List<MedicinaleCartella> toEntity(List<MedicinaleCartellaDto> dtos);
}
