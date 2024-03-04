package com.mspaziente.mapper.malattia;

import com.mspaziente.dto.MalattiaDto;
import com.mspaziente.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaMapper {
    MalattiaMapper INSTANCE = Mappers.getMapper(MalattiaMapper.class);

    Malattia toEntity(MalattiaDto dto);
    List<Malattia> toEntity(List<MalattiaDto> dto);
}
