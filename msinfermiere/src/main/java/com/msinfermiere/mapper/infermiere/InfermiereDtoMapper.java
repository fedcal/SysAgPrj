package com.msinfermiere.mapper.infermiere;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.entity.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfermiereDtoMapper {
    InfermiereDtoMapper INSTANCE = Mappers.getMapper(InfermiereDtoMapper.class);
    InfermiereDto toDto(Infermiere dto);
    List<InfermiereDto> toDto(List<Infermiere> dto);
}
