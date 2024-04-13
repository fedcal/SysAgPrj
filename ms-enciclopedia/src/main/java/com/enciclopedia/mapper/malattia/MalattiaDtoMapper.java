package com.enciclopedia.mapper.malattia;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MalattiaDtoMapper {
    MalattiaDtoMapper INSTANCE = Mappers.getMapper( MalattiaDtoMapper.class );
    MalattiaDto toDto(Malattia dto);
    List<MalattiaDto> toDto(List<Malattia> dto);
}
