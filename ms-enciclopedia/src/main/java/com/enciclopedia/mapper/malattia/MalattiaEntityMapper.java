package com.enciclopedia.mapper.malattia;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.entity.Malattia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MalattiaEntityMapper {
    MalattiaEntityMapper INSTANCE = Mappers.getMapper( MalattiaEntityMapper.class );
    Malattia toEntity(MalattiaDto entity);
    List<Malattia> toEntity(List<MalattiaDto> entities);
}
