package com.msmedico.mapper.relationentities.malattiacartella;

import com.msmedico.dto.relationentities.MalattiaCartellaDto;
import com.msmedico.entity.relationentities.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaCartellaDtoMapper {
    MalattiaCartellaDtoMapper INSTANCE = Mappers.getMapper(MalattiaCartellaDtoMapper.class);

    MalattiaCartellaDto toDto(MalattiaCartella entity);
    List<MalattiaCartellaDto> toDto(List<MalattiaCartella> entities);
}
