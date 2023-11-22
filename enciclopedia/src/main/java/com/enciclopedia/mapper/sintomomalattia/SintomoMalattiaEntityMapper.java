package com.enciclopedia.mapper.sintomomalattia;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SintomoMalattiaEntityMapper {
    SintomoMalattiaEntityMapper INSTANCE = Mappers.getMapper(SintomoMalattiaEntityMapper.class);

    SintomoMalattia toDto(SintomoMalattiaDto entity);
    List<SintomoMalattia> toDto(List<SintomoMalattiaDto> entity);
}
