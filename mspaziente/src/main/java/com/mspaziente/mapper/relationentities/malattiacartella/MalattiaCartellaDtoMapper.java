package com.mspaziente.mapper.relationentities.malattiacartella;

import com.mspaziente.dto.relationentities.MalattiaCartellaDto;
import com.mspaziente.entity.relationentities.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaCartellaDtoMapper {
    MalattiaCartellaDtoMapper INSTANCE = Mappers.getMapper(MalattiaCartellaDtoMapper.class);

    MalattiaCartellaDto toDto(MalattiaCartella entity);
    List<MalattiaCartellaDto> toDto(List<MalattiaCartella> entity);
}
