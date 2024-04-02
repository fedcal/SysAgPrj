package com.msinfermiere.mapper.relationentities.malattiacartella;

import com.msinfermiere.dto.relationentities.MalattiaCartellaDto;
import com.msinfermiere.entity.relationentites.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MalattiaCartellaDtoMapper {
    MalattiaCartellaDtoMapper INSTANCE = Mappers.getMapper(MalattiaCartellaDtoMapper.class);

    MalattiaCartellaDto toDto(MalattiaCartella entity);
    List<MalattiaCartellaDto> toDto(List<MalattiaCartella> entity);
}
