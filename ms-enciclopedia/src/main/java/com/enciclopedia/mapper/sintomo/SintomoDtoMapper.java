package com.enciclopedia.mapper.sintomo;

import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.entity.Sintomo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SintomoDtoMapper {
    SintomoDtoMapper INSTANCE = Mappers.getMapper(SintomoDtoMapper.class);

    SintomoDto toDto(Sintomo entity);
    List<SintomoDto> toDto(List<Sintomo> entity);
}
