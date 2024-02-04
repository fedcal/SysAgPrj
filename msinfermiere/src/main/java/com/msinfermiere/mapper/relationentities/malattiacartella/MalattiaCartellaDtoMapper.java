package com.msinfermiere.mapper.relationentities.malattiacartella;

import com.msinfermiere.dto.relationentities.MalattiaCartellaDto;
import com.msinfermiere.entity.relationentites.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MalattiaCartellaDtoMapper {
    MalattiaCartellaDtoMapper INSTANCE = Mappers.getMapper(MalattiaCartellaDtoMapper.class);

    MalattiaCartellaDto toEntity(MalattiaCartella entity);
    List<MalattiaCartellaDto> toEntity(List<MalattiaCartella> entity);
}
