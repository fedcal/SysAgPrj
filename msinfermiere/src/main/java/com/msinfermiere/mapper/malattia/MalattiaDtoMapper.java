package com.msinfermiere.mapper.malattia;

import com.msinfermiere.dto.MalattiaDto;
import com.msinfermiere.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaDtoMapper {
    MalattiaDtoMapper INSTANCE = Mappers.getMapper(MalattiaDtoMapper.class);
    MalattiaDto toDto(Malattia entity);
    List<MalattiaDto> toDto(List<Malattia> entity);
}
