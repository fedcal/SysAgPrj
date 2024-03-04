package com.mspaziente.mapper.malattia;

import com.mspaziente.dto.MalattiaDto;
import com.mspaziente.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaDtoMapper {
    MalattiaDtoMapper INSTANCE = Mappers.getMapper(MalattiaDtoMapper.class);

    MalattiaDto toDto(Malattia entity);
    List<MalattiaDto> toDto(List<Malattia> entity);
}
