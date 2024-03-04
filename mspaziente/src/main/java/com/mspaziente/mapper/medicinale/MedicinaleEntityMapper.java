package com.mspaziente.mapper.medicinale;

import com.mspaziente.dto.MedicinaleDto;
import com.mspaziente.entity.Medicinale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicinaleEntityMapper {
    MedicinaleEntityMapper INSTANCE = Mappers.getMapper(MedicinaleEntityMapper.class);

    Medicinale toEntity(MedicinaleDto dto);
    List<Medicinale> toEntity(List<MedicinaleDto> dto);
}
