package com.mspaziente.mapper.infermiere;

import com.mspaziente.dto.InfermiereDto;
import com.mspaziente.entity.Infermiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfermiereDtoMapper {
    InfermiereDtoMapper INSTANCE = Mappers.getMapper(InfermiereDtoMapper.class);

    InfermiereDto toDto(Infermiere entity);
    List<InfermiereDto> toDto(List<Infermiere> entity);
}
