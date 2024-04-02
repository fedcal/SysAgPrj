package com.msinfermiere.mapper.relationentities.malattiacartella;

import com.msinfermiere.dto.relationentities.MalattiaCartellaDto;
import com.msinfermiere.entity.relationentites.MalattiaCartella;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MalattiaCartellaEntityMapper {
    MalattiaCartellaEntityMapper INSTANCE = Mappers.getMapper(MalattiaCartellaEntityMapper.class);

    MalattiaCartella toEntity(MalattiaCartellaDto dto);
    List<MalattiaCartella> toEntity(List<MalattiaCartellaDto> dto);
}
