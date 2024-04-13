package com.enciclopedia.mapper.sintomomalattia;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SintomoMalattiaEntityMapper {
    SintomoMalattiaEntityMapper INSTANCE = Mappers.getMapper(SintomoMalattiaEntityMapper.class);

    SintomoMalattia toEntity(SintomoMalattiaDto entity);
    List<SintomoMalattia> toEntity(List<SintomoMalattiaDto> entity);
}
