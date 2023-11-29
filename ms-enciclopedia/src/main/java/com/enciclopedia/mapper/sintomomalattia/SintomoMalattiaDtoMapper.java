package com.enciclopedia.mapper.sintomomalattia;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SintomoMalattiaDtoMapper {
    SintomoMalattiaDtoMapper INSTANCE = Mappers.getMapper(SintomoMalattiaDtoMapper.class);

    SintomoMalattiaDto toDto(SintomoMalattia entity);
    List<SintomoMalattiaDto> toDto(List<SintomoMalattia> entity);
}
