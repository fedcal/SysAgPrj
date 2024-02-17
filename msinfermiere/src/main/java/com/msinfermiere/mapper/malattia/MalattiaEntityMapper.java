package com.msinfermiere.mapper.malattia;

import com.msinfermiere.dto.MalattiaDto;
import com.msinfermiere.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaEntityMapper {
    MalattiaEntityMapper INSTANCE = Mappers.getMapper(MalattiaEntityMapper.class);
    Malattia toEntity(MalattiaDto dto);
    List<Malattia> toEntity(List<MalattiaDto> dto);
}
