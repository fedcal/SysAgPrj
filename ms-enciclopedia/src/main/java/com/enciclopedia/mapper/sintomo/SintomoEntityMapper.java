package com.enciclopedia.mapper.sintomo;

import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.entity.Sintomo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SintomoEntityMapper {
    SintomoEntityMapper INSTANCE = Mappers.getMapper(SintomoEntityMapper.class);

    Sintomo toDto(SintomoDto entity);
    List<Sintomo> toDto(List<SintomoDto> entity);
}
