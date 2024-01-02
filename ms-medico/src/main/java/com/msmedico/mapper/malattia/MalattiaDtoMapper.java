package com.msmedico.mapper.malattia;

import com.msmedico.dto.MalattiaDto;
import com.msmedico.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MalattiaDtoMapper {
    MalattiaDtoMapper INSTANCE = Mappers.getMapper( MalattiaDtoMapper.class );

    MalattiaDto toEntity(Malattia entity);
    List<MalattiaDto> toEntity(List<Malattia> entities);
}
