package com.mspaziente.mapper.relationentities.malattiacartella;

import com.mspaziente.dto.relationentities.MalattiaCartellaDto;
import com.mspaziente.entity.relationentities.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaCartellaEntityMapper {
    MalattiaCartellaEntityMapper INSTANCE = Mappers.getMapper(MalattiaCartellaEntityMapper.class);

    MalattiaCartella toEntity(MalattiaCartellaDto dto);
    List<MalattiaCartella> toEntity(List<MalattiaCartellaDto> dto);
}
