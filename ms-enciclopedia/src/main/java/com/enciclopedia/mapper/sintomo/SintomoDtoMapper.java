package com.enciclopedia.mapper.sintomo;

import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.entity.Sintomo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SintomoDtoMapper {
    SintomoDtoMapper INSTANCE = Mappers.getMapper(SintomoDtoMapper.class);

    SintomoDto toDto(Sintomo dto);
    List<SintomoDto> toDto(List<Sintomo> dto);
}
