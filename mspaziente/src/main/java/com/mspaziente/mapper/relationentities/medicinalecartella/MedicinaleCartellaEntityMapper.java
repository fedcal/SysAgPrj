package com.mspaziente.mapper.relationentities.medicinalecartella;

import com.mspaziente.dto.relationentities.MedicinaleCartellaDto;
import com.mspaziente.entity.relationentities.MedicinaleCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleCartellaEntityMapper {
    MedicinaleCartellaEntityMapper INSTANCE = Mappers.getMapper(MedicinaleCartellaEntityMapper.class);

    MedicinaleCartella toEntity(MedicinaleCartellaDto dto);
    List<MedicinaleCartella> toEntity(List<MedicinaleCartellaDto> dto);
}
