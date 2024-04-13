package com.enciclopedia.mapper.sintomomalattia;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SintomoMalattiaDtoMapper {
    SintomoMalattiaDtoMapper INSTANCE = Mappers.getMapper(SintomoMalattiaDtoMapper.class);

    SintomoMalattiaDto toDto(SintomoMalattia dto);
    List<SintomoMalattiaDto> toDto(List<SintomoMalattia> dto);
}
